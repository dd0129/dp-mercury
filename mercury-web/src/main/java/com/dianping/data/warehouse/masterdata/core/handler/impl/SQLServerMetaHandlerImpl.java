package com.dianping.data.warehouse.masterdata.core.handler.impl;

import com.dianping.data.warehouse.domain.McColumnInfo;
import com.dianping.data.warehouse.domain.McTableInfo;
import com.dianping.data.warehouse.domain.McTableQuery;
import com.dianping.data.warehouse.masterdata.core.dao.BaseDAO;
import com.dianping.data.warehouse.masterdata.core.dao.impl.McSqlserverMetaSqlMap;
import com.dianping.data.warehouse.masterdata.core.handler.AbstractMetaHandler;
import com.dianping.data.warehouse.masterdata.core.handler.DataBaseMetaHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;

public class SQLServerMetaHandlerImpl extends AbstractMetaHandler implements DataBaseMetaHandler {

    @Resource(name = "sqlservermetaDAOImpl")
    private BaseDAO dao;



    private static Logger logger = LoggerFactory
            .getLogger(SQLServerMetaHandlerImpl.class);

    @Override
    public List<McTableInfo> getTableList(McTableQuery query) {
        try {
            DataSource dataSource = this.getDataSource("sqlserver", query.getDbName());
            dao.reset(dataSource);
            return (List<McTableInfo>) dao.getByQuery(query,
                    McSqlserverMetaSqlMap.STATEMENT_GET_SQLSERVER_TABLE_LIST);
        } catch (Exception e) {
            logger.error("get sqlserver table list failure", e);
            throw new RuntimeException("get sqlserver table list failure", e);
        }
    }3

    @Override
    public List<McColumnInfo> getColumnList(McTableQuery query) {
        try {
            dao.reset(this.getDataSource("sqlserver", query.getDbName()));
            return (List<McColumnInfo>) dao.getByQuery(query,
                    McSqlserverMetaSqlMap.STATEMENT_GET_SQLSERVER_COLUMN_LIST);
        } catch (Exception e) {
            logger.error("get sqlserver column list failure", e);
            throw new RuntimeException("get sqlserver column list failure", e);
        }

    }

    @Override
    public List<String> getDbList(String storage_type) {
        try {
            dao.reset(this.getDataSource("mysql", "DianPingDW"));
            return (List<String>) dao.getByQuery(storage_type, McSqlserverMetaSqlMap.STATEMENT_GET_SQLSERVER_DBANME_LIST);
        } catch (Exception e) {
            logger.error("get sqlserver db list failure", e);
            throw new RuntimeException("get sqlserver db list failure", e);
        }
    }


}
