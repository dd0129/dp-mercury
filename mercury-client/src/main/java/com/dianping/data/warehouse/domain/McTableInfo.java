package com.dianping.data.warehouse.domain;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

public class McTableInfo implements Serializable{

    private static final long serialVersionUID = 6451402200735612900L;
    /**
	 * 
	 */
	private Integer table_id;
    @NotNull
	private String schema_name;
	@NotNull
    private String table_name;
	@NotNull
    private String storage_type;
	@NotNull
    private String db_name;
    private String table_owner;
	private String table_desc;
	private long table_size;
    private String refresh_cycle;
    private String refresh_type;


    public Integer getRefresh_datum_date() {
        return refresh_datum_date;
    }

    public void setRefresh_datum_date(Integer refresh_datum_date) {
        this.refresh_datum_date = refresh_datum_date;
    }

    public String getRefresh_offset() {
        return refresh_offset;
    }

    public void setRefresh_offset(String refresh_offset) {
        this.refresh_offset = refresh_offset;
    }

    private Integer refresh_datum_date;
    private  String refresh_offset;
	private Integer table_access_level;
	private String table_access_desc;
	private String add_time;
	private String update_time;
    private int status;
    public List<McColumnInfo> getColumns() {
        return columns;
    }
    public void setColumns(List<McColumnInfo> columns) {
        this.columns = columns;
    }
    private List<McColumnInfo> columns;

    
    
	
	public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public Integer getTable_id() {
		return table_id;
	}
	public void setTable_id(Integer tableId) {
		table_id = tableId;
	}
	public String getSchema_name() {
		return schema_name;
	}
	public void setSchema_name(String schemaName) {
		schema_name = schemaName;
	}
	public String getTable_name() {
		return table_name;
	}
	public void setTable_name(String tableName) {
		table_name = tableName;
	}
	public String getStorage_type() {
		return storage_type;
	}
	public void setStorage_type(String storageType) {
		storage_type = storageType;
	}
	public String getTable_owner() {
		return table_owner;
	}
	public void setTable_owner(String tableOwner) {
		table_owner = tableOwner;
	}
	public String getTable_desc() {
		return table_desc;
	}
	public void setTable_desc(String tableDesc) {
		table_desc = tableDesc;
	}
	public long getTable_size() {
		return table_size;
	}
	public void setTable_size(long tableSize) {
		table_size = tableSize;
	}
	public String getRefresh_cycle() {
		return refresh_cycle;
	}
	public void setRefresh_cycle(String refreshCycle) {
		refresh_cycle = refreshCycle;
	}
	public String getRefresh_type() {
		return refresh_type;
	}
	public void setRefresh_type(String refreshType) {
		refresh_type = refreshType;
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
	public Integer getTable_access_level() {
		return table_access_level;
	}
	public void setTable_access_level(Integer tableAccessLevel) {
		table_access_level = tableAccessLevel;
	}
	public String getTable_access_desc() {
		return table_access_desc;
	}
	public void setTable_access_desc(String tableAccessDesc) {
		table_access_desc = tableAccessDesc;
	}
    public String getDb_name() {
        return db_name;
    }
    public void setDb_name(String db_name) {
        this.db_name = db_name;
    }
}
