package com.dianping.data.warehouse.domain;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by shanshan.jin on 14-3-5.
 */
public class TableExistStatus implements Serializable{
    private static final long serialVersionUID = -5549039784555283582L;
    private Map<String, Boolean> existMap;
    private Map<String,Integer> taskIdMap;
    private Map<String,Boolean> taskStorageLocationMap; //判断task存储的位置
    private String cluster_name;
    private String db_name;
    private String table_name;

    public Map<String, Boolean> getExistMap() {
        return existMap;
    }

    public void setExistMap(Map<String, Boolean> existMap) {
        this.existMap = existMap;
    }

    public Map<String, Integer> getTaskIdMap() {
        return taskIdMap;
    }

    public void setTaskIdMap(Map<String, Integer> taskIdMap) {
        this.taskIdMap = taskIdMap;
    }

    public String getCluster_name() {
        return cluster_name;
    }

    public void setCluster_name(String cluster_name) {
        this.cluster_name = cluster_name;
    }

    public String getDb_name() {
        return db_name;
    }

    public void setDb_name(String db_name) {
        this.db_name = db_name;
    }

    public String getTable_name() {
        return table_name;
    }

    public void setTable_name(String table_name) {
        this.table_name = table_name;
    }

    public Map<String, Boolean> getTaskStorageLocationMap() {
        return taskStorageLocationMap;
    }

    public void setTaskStorageLocationMap(Map<String, Boolean> taskStorageLocationMap) {
        this.taskStorageLocationMap = taskStorageLocationMap;
    }
}
