package com.dianping.data.warehouse.domain;

import java.io.Serializable;

public class McDataMap implements Serializable {


    private static final long serialVersionUID = -49383516575059272L;
    private int task_id;
    private int parent_db_id;        
    private String parent_schema;       
    private String parent_table_name;   
    private int child_db_id;       
    private String child_schema;        
    private String child_table_name;    

    
    public Integer getTask_id() {
        return task_id;
    }
    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }
    public Integer getParent_db_id() {
        return parent_db_id;
    }
    public void setParent_db_id(int parent_db_id) {
        this.parent_db_id = parent_db_id;
    }
    public String getParent_schema() {
        return parent_schema;
    }
    public void setParent_schema(String parent_schema) {
        this.parent_schema = parent_schema;
    }
    public String getParent_table_name() {
        return parent_table_name;
    }
    public void setParent_table_name(String parent_table_name) {
        this.parent_table_name = parent_table_name;
    }
    public Integer getChild_db_id() {
        return child_db_id;
    }
    public void setChild_db_id(int child_db_id) {
        this.child_db_id = child_db_id;
    }
    public String getChild_schema() {
        return child_schema;
    }
    public void setChild_schema(String child_schema) {
        this.child_schema = child_schema;
    }
    public String getChild_table_name() {
        return child_table_name;
    }
    public void setChild_table_name(String child_table_name) {
        this.child_table_name = child_table_name;
    }
    

}
