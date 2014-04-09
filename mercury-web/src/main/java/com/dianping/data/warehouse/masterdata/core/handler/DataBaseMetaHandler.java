package com.dianping.data.warehouse.masterdata.core.handler;

import com.dianping.data.warehouse.domain.McColumnInfo;
import com.dianping.data.warehouse.domain.McTableInfo;
import com.dianping.data.warehouse.domain.McTableQuery;

import java.util.List;

/**
 * @Author <a href="mailto:tsensue@gmail.com">dishu.chen</a>
 * 14-2-26.
 */
public interface DataBaseMetaHandler {

    /**
     * Find Tables by Query
     * @param query
     * @return
     */
    public List<McTableInfo> getTableList(McTableQuery query);

    public List<McColumnInfo> getColumnList(McTableQuery query);

    public List<String> getDbList(String storage_type);
}
