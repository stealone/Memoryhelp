package com.lifesoft.memoryhelp.dao.core;

import com.lifesoft.memoryhelp.security.DriverException;
import com.lifesoft.memoryhelp.security.WrongUserConnectionException;

public interface DbConnectionProvider {
    public Object getDbConnection() throws DriverException, WrongUserConnectionException;
    public boolean isConnectedToDb();
    public void desconnect() throws Exception;
}
