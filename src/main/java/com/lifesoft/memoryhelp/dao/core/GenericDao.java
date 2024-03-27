package com.lifesoft.memoryhelp.dao.core;

import com.lifesoft.memoryhelp.model.core.GenericEntity;

public interface GenericDao<T extends GenericEntity> extends Dao<T>{
    /**
     *
     * @param connectionProvider
     */
    public void setDBConnectionProvider(DbConnectionProvider connectionProvider);
}

