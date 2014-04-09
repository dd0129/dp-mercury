package com.dianping.data.warehouse.domain;




import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.math.BigInteger;

public class McColumnInfo implements Serializable {

    private static final long serialVersionUID = -4003920617705418688L;
    private Long column_id;
    private Integer table_id;
    @NotNull(message = "column_name")
    private String column_name;
    @NotNull(message = "column_type")
    private String column_type;
    private String column_desc;
    private String default_value;
    private Integer column_access_level;
    private String column_access_desc;
    private Integer column_rn;
    @NotNull(message = "is_partition_column")
    private Integer is_partition_column;
    private String add_time;
    private String update_time;

    public Integer getIs_partition_column() {
        return is_partition_column;
    }

    public void setIs_partition_column(Integer is_partition_column) {
        this.is_partition_column = is_partition_column;
    }

    public Long getColumn_id() {
        return column_id;
    }

    public void setColumn_id(Long columnId) {
        column_id = columnId;
    }

    public Integer getTable_id() {
        return table_id;
    }

    public void setTable_id(Integer tableId) {
        table_id = tableId;
    }

    public String getColumn_name() {
        return column_name;
    }

    public void setColumn_name(String columnName) {
        column_name = columnName;
    }

    public String getColumn_type() {
        return column_type;
    }

    public void setColumn_type(String columnType) {
        column_type = columnType;
    }

    public String getColumn_desc() {
        return column_desc;
    }

    public void setColumn_desc(String columnDesc) {
        column_desc = columnDesc;
    }

    public String getDefault_value() {
        return default_value;
    }

    public void setDefault_value(String defaultValue) {
        default_value = defaultValue;
    }

    public String getAdd_time() {
        return add_time;
    }

    public void setAdd_time(String addTime) {
        add_time = addTime;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String updateTime) {
        update_time = updateTime;
    }

    public void setColumn_access_desc(String column_access_desc) {
        this.column_access_desc = column_access_desc;
    }

    public String getColumn_access_desc() {
        return column_access_desc;
    }

    public void setColumn_access_level(Integer column_access_level) {
        this.column_access_level = column_access_level;
    }

    public Integer getColumn_access_level() {
        return column_access_level;
    }

    public void setColumn_rn(Integer column_rn) {
        this.column_rn = column_rn;
    }

    public Integer getColumn_rn() {
        return column_rn;
    }
}
