package com.dianping.data.warehouse.masterdata.core.service;

import com.dianping.data.warehouse.domain.*;
import com.dianping.data.warehouse.masterdata.core.dao.BaseDAO;
import com.dianping.data.warehouse.masterdata.core.dao.impl.McMysqlSqlMap;
import com.dianping.data.warehouse.masterdata.service.MercuryService;
import com.dianping.pigeon.remoting.provider.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.*;

@Service
public class MercuryServiceImpl implements MercuryService {
    @SuppressWarnings("rawtypes")
    @Resource(name = "mysqlDAOImpl")
    private BaseDAO dao;

    private static Logger logger = LoggerFactory
            .getLogger(MercuryServiceImpl.class);

    @SuppressWarnings("unchecked")
    @Override
    public List<Integer> getParentTaskId(McTableInfo table) {
        try {
            return (List<Integer>) dao.getByQuery(table,
                    McMysqlSqlMap.STATEMENT_GET_PARENT_TASK_ID);
        } catch (Exception e) {
            logger.error("get parent taskid failure", e);
            throw new RuntimeException("get parent taskid failure", e);
        }
    }

    @Override
    public List<TableExistStatus> gettableExistStatus(List<McTableInfo> tables) {
        if (null == tables || tables.size()<1){
            return null;
        }else{
            try { Map<String, Object> map = new HashMap<String, Object>();
                map.put("tables",tables);
                List<TableExistInfo> tableExistInfos = (List<TableExistInfo>) dao.getByQuery(map,
                        McMysqlSqlMap.STATEMENT_GET_TABLE_EXIST_STATUS);
                List<TableExistStatus> tableExistStatuses = new ArrayList<TableExistStatus>();
                for(TableExistInfo tableExistInfo : tableExistInfos){
                    TableExistStatus tableExistStatus = new TableExistStatus();
                    tableExistStatus.setDb_name(tableExistInfo.getDb_name());
                    tableExistStatus.setCluster_name(tableExistInfo.getCluster_name());
                    tableExistStatus.setTable_name(tableExistInfo.getTable_name());
                    Map<String, Boolean> existMap = new HashMap<String, Boolean>();
                    existMap.put("hive",tableExistInfo.getHiveExist());
                    existMap.put("gpReport",tableExistInfo.getGpReportExist());
                    existMap.put("GpAnalysis",tableExistInfo.getGpAnalysisExist());
                    tableExistStatus.setExistMap(existMap);
                    Map<String,Integer> taskIdMap = new HashMap<String, Integer>();
                    taskIdMap.put("hive",tableExistInfo.getHiveTaskId());
                    taskIdMap.put("gpReport",tableExistInfo.getGpReportTaskId());
                    taskIdMap.put("GpAnalysis",tableExistInfo.getGpAnalysisTaskId());
                    tableExistStatus.setTaskIdMap(taskIdMap);
                    tableExistStatuses.add(tableExistStatus);
                }
                return tableExistStatuses;
            } catch (Exception e) {
                logger.error("get table exist status", e);
                throw new RuntimeException("get table exist status failure", e);
            }
        }

    }

    @Override
    public boolean saveMercuryInfo(List<McTableInfo> sourceTables,
            McTableInfo targetTable, List<Integer> taskIdList) {
        try {
            dao.insert(targetTable, McMysqlSqlMap.STATEMENT_INSERT_MCTABLEINFO);
            Integer tableId = (Integer) dao.getUniqueByQuery(targetTable,
                    McMysqlSqlMap.STATEMENT_GET_TABLE_ID) ;

            List<McColumnInfo> columns = targetTable.getColumns();
            for (McColumnInfo column : columns) {
                column.setTable_id(tableId);
                column.setColumn_id(Long.valueOf(tableId.toString().concat(column.getColumn_rn().toString())));
            }
            dao.insert(columns, McMysqlSqlMap.STATEMENT_INSERT_MCCOLUMNINFO);
            Integer tgtDbId = (Integer) dao.getUniqueByQuery(targetTable,
                    McMysqlSqlMap.STATEMENT_GET_DB_ID);
            tgtDbId = tgtDbId == null ? 0: tgtDbId;
            McDataTaskMap dataTaskMap = new McDataTaskMap();
            dataTaskMap.setTable_id(tableId);

            dataTaskMap.setDb_id(tgtDbId);
//            ValidatorUtils.validateModel(dataTaskMap);
            for(Integer taskId : taskIdList){
                dataTaskMap.setTask_id(taskId);
                dao.insert(dataTaskMap,
                        McMysqlSqlMap.STATEMENT_INSERT_MC_DATA_TASK_MAP);
            }
            McDataMap dataMap = new McDataMap();
            dataMap.setChild_db_id(tgtDbId);
            dataMap.setChild_schema(targetTable.getSchema_name());
            dataMap.setChild_table_name(targetTable.getTable_name());
            dataMap.setTask_id(taskIdList.get(0));
            Iterator<McTableInfo> sourceTableIt = sourceTables.iterator();
            while (sourceTableIt.hasNext()) {
                McTableInfo sourceTable = sourceTableIt.next();
                Integer srcDbId = (Integer) dao.getUniqueByQuery(sourceTable,
                        McMysqlSqlMap.STATEMENT_GET_DB_ID);
                srcDbId = srcDbId == null ? 0: srcDbId;
                dataMap.setParent_db_id(srcDbId);
                dataMap.setParent_schema(sourceTable.getSchema_name());
                dataMap.setParent_table_name(sourceTable.getTable_name());
                dao.insert(dataMap, McMysqlSqlMap.STATEMENT_INSERT_MC_DATA_MAP);
            }
            return true;
        } catch (Exception e) {
            logger.error("save mercury info failure", e);
            return false;
        }
    }

    @Override
    public boolean deleteMercuryInfo(List<McTableInfo> sourceTables,
            McTableInfo targetTable, List<Integer> taskIdList) {
        try {
            dao.delete(targetTable,McMysqlSqlMap.STATEMENT_DELETE_MCTABLEINFO );
            dao.delete(targetTable,McMysqlSqlMap.STATEMENT_DELETE_MCCOLUMNINFO);
            for(Integer taskId : taskIdList){
                dao.delete(taskId,McMysqlSqlMap.STATEMENT_DELETE_MC_DATA_MAP);
            }
            dao.delete(taskIdList.get(0),McMysqlSqlMap.STATEMENT_DELETE_MC_DATA_TASK_MAP);
            return true;
        }catch (Exception e){
            logger.error("delete MercuryInfo error", e);
            throw new RuntimeException("delete MercuryInfo error", e);
        }
    }

    @Override
    public boolean updateMercuryInfo(McTableInfo targetTable) {
        Integer tableId = (Integer) dao.getUniqueByQuery(targetTable, McMysqlSqlMap.STATEMENT_GET_TABLE_ID);
        try {
            if(tableId != null){
                targetTable.setTable_id(tableId);
                List<McColumnInfo> columns = targetTable.getColumns();
                for (McColumnInfo column : columns) {
                    column.setTable_id(tableId);
                    column.setColumn_id(Long.valueOf(tableId.toString().concat(column.getColumn_rn().toString())));
                }
                dao.update(targetTable,McMysqlSqlMap.STATEMENT_UPDATE_TABLEINFO);
                dao.delete(targetTable,McMysqlSqlMap.STATEMENT_DELETE_MCCOLUMNINFO);
                dao.insert(columns,McMysqlSqlMap.STATEMENT_INSERT_MCCOLUMNINFO);
                return true;

            }else{
                dao.insert(targetTable, McMysqlSqlMap.STATEMENT_INSERT_MCTABLEINFO);
                tableId = (Integer) dao.getUniqueByQuery(targetTable,
                        McMysqlSqlMap.STATEMENT_GET_TABLE_ID) ;
                List<McColumnInfo> columns = targetTable.getColumns();
                for (McColumnInfo column : columns) {
                    column.setTable_id(tableId);
                    column.setColumn_id(Long.valueOf(tableId.toString().concat(column.getColumn_rn().toString())));
                }
                dao.delete(targetTable,McMysqlSqlMap.STATEMENT_DELETE_MCCOLUMNINFO);
                dao.insert(columns,McMysqlSqlMap.STATEMENT_INSERT_MCCOLUMNINFO);
            }
            return  true;
        }catch (Exception e){
        logger.error("update mercuryinfo error" , e);
        throw new RuntimeException("update mercuryinfo error" , e);
    }
 }

    @Override
    public List<McColumnInfo> getTgtColumnList(McTableInfo table) {
        try {
            return (List<McColumnInfo>) dao.getByQuery(table,
                    McMysqlSqlMap.STATEMENT_GET_TGT_COLUMN_LIST);
        } catch (Exception e) {
            logger.error("get table exist status", e);
            throw new RuntimeException("get target column list failure", e);
        }
    }

    @Override
    public McTableInfo getTaskTable(int taskId) {
        try {
            return (McTableInfo) dao.getById(taskId,
                    McMysqlSqlMap.STATEMENT_GET_TASK_TABLE);
        } catch (Exception e) {
            logger.error("get task table error", e);
            throw new RuntimeException("get task table error", e);
        }
    }

    @Override
    public boolean updateTableStatus(int taskId, int status) {
        try {
            McTableInfo table = (McTableInfo) dao.getById(taskId,
                    McMysqlSqlMap.STATEMENT_GET_TASK_TABLE);
            if(null == table){
                logger.error("there is no table map this task");
            }else{
                table.setStatus(status);
                dao.update(table,McMysqlSqlMap.STATEMENT_UPDATE_TABLEINFO);
            }
            return true;
        } catch (Exception e) {
            logger.error("get task table error", e);
            throw new RuntimeException("get task table error", e);
        }
    }

    @Override
    public List<Integer> getTableIDbyTaskID(Integer taskId) {
        List<Integer> tableId = null;
        try {
            tableId = (List<Integer>)dao.getByQuery(taskId,McMysqlSqlMap.STATEMENT_GET_TABLE_ID_BY_TASK_ID);
            if(null == tableId){
                logger.error("there is no tableId map this taskId: "+taskId);
            }
        } catch (Exception e) {
            logger.error("get tableId error", e);
            throw new RuntimeException("get tableId error", e);
        }
        return tableId;
    }

    @Override
    public List<Integer> getTaskIDbyTableID(Integer tableId) {
        List<Integer> taskIds = null;
        try {
            taskIds = (List<Integer>)dao.getByQuery(tableId,McMysqlSqlMap.STATEMENT_GET_TASK_ID_BY_TABLE_ID);
            if (null == taskIds || taskIds.isEmpty()){
                logger.error("there is no taskId map this tableId: "+tableId);
            }
        } catch (Exception e){
            logger.error("get taskId error", e);
            throw new RuntimeException("get taskId error", e);
        }
        return taskIds;
    }
}
