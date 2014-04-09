package com.dianping.data.warehouse.domain;

import java.io.Serializable;

public class TableExistInfo implements Serializable {
    private static final long serialVersionUID = 4369833848236053289L;

    public Boolean getHiveExist() {
        return hiveExist;
    }
    public void setHiveExist(Boolean hiveExist) {
        this.hiveExist = hiveExist;
    }
    public Boolean getGpAnalysisExist() {
        return gpAnalysisExist;
    }
    public void setGpAnalysisExist(Boolean gpAnalysisExist) {
        this.gpAnalysisExist = gpAnalysisExist;
    }
    public Boolean getGpReportExist() {
        return gpReportExist;
    }
    public void setGpReportExist(Boolean gpReportExist) {
        this.gpReportExist = gpReportExist;
    }

    public int getHiveTaskId() {
        return hiveTaskId;
    }

    public void setHiveTaskId(int hiveTaskId) {
        this.hiveTaskId = hiveTaskId;
    }

    public Integer getGpAnalysisTaskId() {
        return gpAnalysisTaskId;
    }

    public void setGpAnalysisTaskId(int gpAnalysisTaskId) {
        this.gpAnalysisTaskId = gpAnalysisTaskId;
    }

    public Integer getGpReportTaskId() {
        return gpReportTaskId;
    }

    public void setGpReportTaskId(int gpReportTaskId) {
        this.gpReportTaskId = gpReportTaskId;
    }

    private Integer hiveTaskId;
    private Integer gpAnalysisTaskId;
    private Integer gpReportTaskId;
    private Boolean hiveExist;
    private Boolean gpAnalysisExist;
    private Boolean gpReportExist;
    private String cluster_name;
    private String db_name;
    private String table_name;

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

}
