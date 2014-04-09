package com.dianping.data.warehouse.masterdata.core.handler;

import com.dianping.data.warehouse.masterdata.service.McMetaService;
import com.dianping.lion.EnvZooKeeperConfig;
import com.dianping.lion.client.ConfigCache;
import com.dianping.lion.client.LionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shanshan.jin on 14-2-26.
 */
@Service
public class DataSourceManager {
    private static Logger logger = LoggerFactory.getLogger(DataSourceManager.class);
    @Resource(name = "McMetaServiceImpl")
    private McMetaService metaService;
    private static Map<String, DataSource> dsMap = null;

    private DriverManagerDataSource getDataSourceFromLion(String storageType, String dbName) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        ConfigCache configCache = null;
        try {
            configCache = ConfigCache.getInstance(EnvZooKeeperConfig.getZKAddress());
            dataSource.setUrl(configCache.getProperty("mercury.".concat(dbName).concat(".url")));
            if (storageType.equals("mysql")) {
                dataSource.setDriverClassName("com.mysql.jdbc.Driver");
            } else if (storageType.equals("sqlserver")) {
                dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            }
            dataSource.setUsername(configCache.getProperty("mercury.".concat(dbName).concat(".username")));
            dataSource.setPassword(configCache.getProperty("mercury.".concat(dbName).concat(".password")));
        } catch (Exception e) {
            //logger.error("load lion config error", e);
        }
        return dataSource;
    }


    public DataSource getDataSource(String storageType, String dbName) {
        if (null == dsMap) {
            init();
        }
        DriverManagerDataSource dataSource = (DriverManagerDataSource) dsMap.get(dbName);
        if (null == dataSource) {
            dataSource = getDataSourceFromLion(storageType, dbName);
            dsMap.put(dbName, dataSource);
        }
        return dataSource;
    }

    protected synchronized void init() {
        if (null == dsMap) {
            dsMap = new HashMap<String, DataSource>();
            List<String> dbNames = metaService.getDbList("mysql");
            if (null != dbNames) {
                for (String dbName : dbNames) {
                    dsMap.put(dbName, getDataSourceFromLion("mysql", dbName));
                }
            }
            dbNames = metaService.getDbList("sqlserver");
            if (null != dbNames) {
                for (String dbName : dbNames) {
                    dsMap.put(dbName, getDataSourceFromLion("sqlserver", dbName));
                }
            }
        }
    }
}
