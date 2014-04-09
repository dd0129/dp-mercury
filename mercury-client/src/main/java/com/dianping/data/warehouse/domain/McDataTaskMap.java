package com.dianping.data.warehouse.domain;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class McDataTaskMap implements Serializable {
    private static final long serialVersionUID = 5326893497966479146L;
    @NotNull
    private int table_id;
    @NotNull
    private int db_id;
    @NotNull
    private int task_id;

    public int getTable_id() {
        return table_id;
    }

    public void setTable_id(int table_id) {
        this.table_id = table_id;
    }

    public int getDb_id() {
        return db_id;
    }

    public void setDb_id(int db_id) {
        this.db_id = db_id;
    }

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }
    

}
