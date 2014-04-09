package com.dianping.data.warehouse.masterdata.core.handler;

import com.dianping.data.warehouse.domain.McColumnInfo;
import com.dianping.data.warehouse.domain.McTableInfo;
import com.dianping.data.warehouse.domain.McTableQuery;
import com.dianping.data.warehouse.masterdata.core.dao.BaseDAO;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;

/**
 * Created by shanshan.jin on 14-2-27.
 */
public abstract class AbstractMetaHandler implements DataBaseMetaHandler{
    @Resource(name = "dataSourceManager")
    private DataSourceManager dataSourceManager;

    protected DataSource getDataSource(String storageType,String dbName){
        return dataSourceManager.getDataSource(storageType, dbName);
    }
}