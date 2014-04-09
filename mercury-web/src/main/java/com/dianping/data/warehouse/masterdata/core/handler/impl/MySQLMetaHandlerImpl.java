package com.dianping.data.warehouse.masterdata.core.handler.impl;

import com.dianping.data.warehouse.domain.McColumnInfo;
import com.dianping.data.warehouse.domain.McTableInfo;
import com.dianping.data.warehouse.domain.McTableQuery;
import com.dianping.data.warehouse.masterdata.core.dao.BaseDAO;
import com.dianping.data.warehouse.masterdata.core.dao.impl.McMysqlMetaSqlMap;
import com.dianping.data.warehouse.masterdata.core.handler.AbstractMetaHandler;
import com.dianping.data.warehouse.masterdata.core.handler.DataBaseMetaHandler;
import com.dianping.data.warehouse.masterdata.core.handler.DataSourceManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.List;

public class MySQLMetaHandlerImpl extends AbstractMetaHandler implements DataBaseMetaHandler {
    @Resource(name = "mysqlmetaDAOImpl")
    private BaseDAO dao;
    private static Logger logger = LoggerFactory.getLogger(MySQLMetaHandlerImpl.class);

    @SuppressWarnings("unchecked")
    @Override
    public List<String> getDbList(String storage_type) {
        try {
            return (List<String>) dao.getByQuery(null, McMysqlMetaSqlMap.STATEMENT_GET_MYSQL_DBNAME_LIST);
        } catch (Exception e) {
            logger.error("get mysql db list failure", e);
            throw new RuntimeException("get mysql db list failure", e);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<McTableInfo> getTableList(McTableQuery query) {
        try {
//            dao.reset(this.getDataSource("mysql", query.getDbName()));
            return (List<McTableInfo>) dao.getByQuery(query, McMysqlMetaSqlMap.STATEMENT_GET_MYSQL_TABLE_LIST);
        } catch (Exception e) {
            logger.error("get mysql table list failure", e);
            throw new RuntimeException("get mysql table list failure", e);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<McColumnInfo> getColumnList(McTableQuery query) {
        try {
            dao.reset(this.getDataSource("mysql", query.getDbName()));
            return (List<McColumnInfo>) dao.getByQuery(query, McMysqlMetaSqlMap.STATEMENT_GET_MYSQL_COLUMN_LIST);
        } catch (Exception e) {
            logger.error("get mysql column list failure", e);
            throw new RuntimeException("get mysql column list failure", e);
        }
    }
}
