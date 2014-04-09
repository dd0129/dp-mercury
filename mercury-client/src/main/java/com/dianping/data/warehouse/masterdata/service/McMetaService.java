package com.dianping.data.warehouse.masterdata.service;

import java.util.List;

import com.dianping.data.warehouse.domain.McColumnInfo;
import com.dianping.data.warehouse.domain.McTableInfo;
import com.dianping.data.warehouse.domain.McTableQuery;

public interface McMetaService {
    //获取表清单
    public List<McTableInfo> getTableList(McTableQuery query);
    
    //获取源表的字段信息
    public List<McColumnInfo> getColumnList(McTableQuery query);

    //获取数据库列表
    public List<String> getDbList(String storageType);

}
