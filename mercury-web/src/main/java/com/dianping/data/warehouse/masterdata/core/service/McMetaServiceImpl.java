package com.dianping.data.warehouse.masterdata.core.service;

import com.dianping.data.warehouse.domain.McColumnInfo;
import com.dianping.data.warehouse.domain.McTableInfo;
import com.dianping.data.warehouse.domain.McTableQuery;
import com.dianping.data.warehouse.masterdata.core.handler.DataBaseMetaHandler;
import com.dianping.data.warehouse.masterdata.service.McMetaService;
import com.dianping.pigeon.remoting.provider.config.annotation.Service;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class McMetaServiceImpl implements McMetaService {

    @Resource(name = "dataBaseMetaHandler")
    private Map<String, DataBaseMetaHandler> handlers;

    private static Logger logger = LoggerFactory.getLogger("McMetaServiceImpl");

    @Override
    public List<McTableInfo> getTableList(McTableQuery query) {
        if (null != query && StringUtils.isNotBlank(query.getStorageType())) {
            DataBaseMetaHandler handler = this.handlers.get(query.getStorageType());
            if (null != handler) {
                return handler.getTableList(query);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    @Override
    public List<McColumnInfo> getColumnList(McTableQuery query) {
        if (null != query && StringUtils.isNotBlank(query.getStorageType())) {
            DataBaseMetaHandler handler = this.handlers.get(query.getStorageType());
            if (null != handler) {
                return handler.getColumnList(query);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    @Override
    public List<String> getDbList(String storage_type) {
        if (StringUtils.isNotBlank(storage_type)) {
            DataBaseMetaHandler handler = this.handlers.get(storage_type);
            if(null == handler){
                handler = this.handlers.get("sqlserver");
            }
            return handler.getDbList(storage_type);
        } else {
            return null;
        }
    }

}
