package com.dianping.data.warehouse.domain;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class McDbInfo implements Serializable {
    private static final long serialVersionUID = 7598275067626179016L;
    private int db_id ;
    @NotNull
    private String cluster_name;
    @NotNull
    private String db_name;
    
    public Integer getDb_id() {
        return db_id;
    }
    public void setDb_id(int db_id) {
        this.db_id = db_id;
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


}
