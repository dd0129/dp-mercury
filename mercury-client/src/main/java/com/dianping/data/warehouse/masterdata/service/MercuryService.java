package com.dianping.data.warehouse.masterdata.service;

import java.util.List;

import com.dianping.data.warehouse.domain.McColumnInfo;
import com.dianping.data.warehouse.domain.McTableInfo;
import com.dianping.data.warehouse.domain.TableExistStatus;

public interface MercuryService {

    //获取父任务id
    public List<Integer> getParentTaskId(McTableInfo table);
    
    //获取表是否入过hive/gp report/gp analysis
    public List<TableExistStatus> gettableExistStatus(List<McTableInfo> tables);

    //保存主数据所有信息
    public boolean saveMercuryInfo(List<McTableInfo> sourceTables,
            McTableInfo targetTable, List<Integer> taskIdList);
    
    //删除主数据所有信息,回滚用
    public boolean deleteMercuryInfo(List<McTableInfo> sourceTables,
            McTableInfo targetTable, List<Integer> taskIdList);

    public boolean updateMercuryInfo(McTableInfo targetTable);
    
  //获取目标表的字段信息
    public List<McColumnInfo> getTgtColumnList(McTableInfo table);

    public McTableInfo getTaskTable(int taskId);

    public boolean updateTableStatus(int taskId,int status);

    public List<Integer> getTableIDbyTaskID(Integer taskId);
    public List<Integer> getTaskIDbyTableID(Integer tableId);
    
}
