package com.lifesoft.memoryhelp.model.medias;

import com.lifesoft.memoryhelp.model.core.Descriptor;
import com.lifesoft.memoryhelp.model.core.GenericEntity;
import com.lifesoft.memoryhelp.model.memory.Note;

import java.io.Serial;
import java.util.Objects;

public abstract class MultimediaFile extends GenericEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    private String fileFormat;

    private long fileSize;

    protected MediaType mediatype;


    /**
     * Default Constructor
     *
     */
    public MultimediaFile() {
        super();
    }

    public MultimediaFile(String name, String fileFormat, Long fileSize) {
        super(name, new Descriptor("File name: " + name + ", Format: " + fileFormat + ", Size: " + fileSize + " Octets"));
        this.fileFormat = fileFormat;
        this.fileSize = fileSize;
    }


    public String getFileFormat() {
        return fileFormat;
    }

    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public MediaType getMediaType() {
        return mediatype;
    }

    public void setMediaType(MediaType mediatype) {
        this.mediatype = mediatype;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.entityName);
        hash = 71 * hash + Objects.hashCode(this.fileFormat);
        hash = 71 * hash + Objects.hashCode(this.fileSize);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MultimediaFile other = (MultimediaFile) obj;
        if (!Objects.equals(this.entityName, other.entityName)) {
            return false;
        }
        if (!Objects.equals(this.fileFormat, other.fileFormat)) {
            return false;
        }
        return Objects.equals(this.fileSize, other.fileSize);
    }

}
