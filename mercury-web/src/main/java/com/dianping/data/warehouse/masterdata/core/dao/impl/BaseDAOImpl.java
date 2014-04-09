package com.dianping.data.warehouse.masterdata.core.dao.impl;

import com.dianping.data.warehouse.masterdata.core.dao.BaseDAO;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import javax.sql.DataSource;
import java.util.List;

/**
 * @Author <a href="mailto:tsensue@gmail.com">dishu.chen</a>
 * 13-12-24.
 */
@SuppressWarnings("unchecked")
public class BaseDAOImpl<T, Q> extends SqlMapClientDaoSupport implements BaseDAO<T, Q> {
    @Override
    public T getById(Integer id, String sqlMapId) {
        return (T) this.getSqlMapClientTemplate().queryForObject(sqlMapId, id);
    }
    @Override
    public List<T> getByQuery(Q q, String sqlMapId) {
        return this.getSqlMapClientTemplate().queryForList(sqlMapId, q);
    }

    @Override
    public void insert(Q q,String sqlMapId){
        this.getSqlMapClientTemplate().insert(sqlMapId,q);
    }

    @Override
    public void update(Q q, String sqlMapId) {
        this.getSqlMapClientTemplate().update(sqlMapId,q);
    }

    @Override
    public void delete(Q q, String sqlMapId) {
        this.getSqlMapClientTemplate().delete(sqlMapId,q);
    }

    @Override
    public void reset(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    @Override
    public T getUniqueByQuery(Q q, String sqlMapId) {
        return (T) this.getSqlMapClientTemplate().queryForObject(sqlMapId, q);
    }
}
