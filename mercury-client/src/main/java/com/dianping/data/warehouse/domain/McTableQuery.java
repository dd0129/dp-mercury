package com.dianping.data.warehouse.domain;

import java.io.Serializable;

/**
 * @Author <a href="mailto:tsensue@gmail.com">dishu.chen</a>
 * 14-2-26.
 */
public class McTableQuery implements Serializable {
    private static final long serialVersionUID = 7793655805335866262L;
    private Integer tableId;
    private String schemaName;
    private String tableName;
    private String storageType;
    private String dbName;
    private String tableOwner;

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getStorageType() {
        return storageType;
    }

    public void setStorageType(String storageType) {
        this.storageType = storageType;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getTableOwner() {
        return tableOwner;
    }

    public void setTableOwner(String tableOwner) {
        this.tableOwner = tableOwner;
    }
}
