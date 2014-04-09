package com.dianping.data.warehouse.masterdata.core.handler.impl;

import com.dianping.data.warehouse.domain.McColumnInfo;
import com.dianping.data.warehouse.domain.McTableInfo;
import com.dianping.data.warehouse.domain.McTableQuery;
import com.dianping.data.warehouse.masterdata.core.dao.BaseDAO;
import com.dianping.data.warehouse.masterdata.core.dao.impl.McHiveMetaSqlMap;
import com.dianping.data.warehouse.masterdata.core.handler.DataBaseMetaHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.List;

public class HiveMetaHandlerImpl implements DataBaseMetaHandler {
    @SuppressWarnings("rawtypes")


    @Resource(name = "hivemetaDAOImpl")
    private BaseDAO dao;


    private static Logger logger = LoggerFactory.getLogger(HiveMetaHandlerImpl.class);

    @SuppressWarnings("unchecked")
    @Override
    public List<String> getDbList(String storage_type) {
        try {
            return (List<String>) dao.getByQuery(null, McHiveMetaSqlMap.STATEMENT_GET_HIVE_DBNAME_LIST);
        } catch (Exception e) {
            logger.error("get hive db list failure", e);
            throw new RuntimeException("get hive db list failure", e);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<McTableInfo> getTableList(McTableQuery query) {
        try {
            return (List<McTableInfo>) dao.getByQuery(query, McHiveMetaSqlMap.STATEMENT_GET_HIVE_TABLE_LIST);
        } catch (Exception e) {
            logger.error("get hive table list failure", e);
            throw new RuntimeException("get hive table list failure", e);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<McColumnInfo> getColumnList(McTableQuery query) {
        try {
            List<McColumnInfo> columnList = (List<McColumnInfo>) dao.getByQuery(query, McHiveMetaSqlMap.STATEMENT_GET_HIVE_COLUMN_LIST);
            List<McColumnInfo> parList = (List<McColumnInfo>) dao.getByQuery(query, McHiveMetaSqlMap.STATEMENT_GET_HIVE_PAR_COLUMN_LIST);
            columnList.addAll(parList);
            return columnList;
        } catch (Exception e) {
            logger.error("get hive column list failure", e);
            throw new RuntimeException("get hive column list failure", e);
        }
    }
}
