package com.lifesoft.memoryhelp.dao.core;

import com.lifesoft.memoryhelp.defender.NoConnectionException;

import java.sql.SQLException;

public interface Dao <T>{

    /**
     * persists an object in the database
     *
     * @param newEntity the entity to be persisted
     * @return the persisted entity
     * @throws java.sql.SQLException if the transaction encounters a problem
     */
    public T createEntity(T newEntity) throws NoConnectionException, SQLException;

    /**
     * update an object from the database
     *
     * @param entity the entity to be updated
     * @return the updated entity
     * @throws java.sql.SQLException if something wen wrong
     */
    public T updateEntity(T entity) throws SQLException , NoConnectionException;

    /**
     * Delete an object from the database
     *
     * @param entity the entity to be deleted
     * @return true if the entity has been deleted or false otherwise
     * @throws Exception if any error occurs
     */
    public boolean deleteEntity(T entity) throws Exception, NoConnectionException;

    /**
     *
     * @param entityName the name of the researched entity
     * @return true if the entity exists or false otherwise
     * @throws SQLException if any sql error occurs
     */
    public boolean entityExist(String entityName) throws SQLException, NoConnectionException;

    public String getEntityTableName();
}
