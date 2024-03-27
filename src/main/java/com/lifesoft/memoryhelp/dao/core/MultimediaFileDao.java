package com.lifesoft.memoryhelp.dao.core;

import com.lifesoft.memoryhelp.model.medias.MultimediaFile;

import java.sql.SQLException;

public interface MultimediaFileDao <T extends MultimediaFile> extends GenericDao<T> {
    /**
     * @param newMultimediaFile
     * @param entityOwnerId
     * @return
     * @throws SQLException
     */
    public T createMultimediaFile(T newMultimediaFile, Long entityOwnerId)throws SQLException;


    /**
     * @param deletedMultimediaFile
     * @return
     * @throws SQLException
     */
    public boolean deleteMultimediaFile(T deletedMultimediaFile)throws SQLException;

}
