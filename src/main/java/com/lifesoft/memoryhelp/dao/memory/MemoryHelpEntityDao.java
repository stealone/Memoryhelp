package com.lifesoft.memoryhelp.dao.memory;

import com.lifesoft.memoryhelp.dao.core.GenericDao;
import com.lifesoft.memoryhelp.defender.NoConnectionException;
import com.lifesoft.memoryhelp.model.core.MemoryHelpEntity;

public interface MemoryHelpEntityDao <T extends MemoryHelpEntity> extends GenericDao<T> {

    public boolean deleteEntityWithNoPicture(T entity, String entityTableName) throws Exception, NoConnectionException;

    public boolean deleteEntity(T entity, String entityTableName) throws Exception, NoConnectionException;
}
