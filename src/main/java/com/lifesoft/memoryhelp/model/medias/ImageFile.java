package com.lifesoft.memoryhelp.model.medias;

import com.lifesoft.memoryhelp.model.memory.MemoryHeader;

public class ImageFile extends MultimediaFile{


    private MemoryHeader ownerEntity;

    /**
     * Default Constructor
     *
     */
    public ImageFile() {
        super();
    }

    public ImageFile(String name, String fileFormat, Long fileSize) {
        super(name, fileFormat,fileSize);
    }



    public MemoryHeader getOwnerEntity() {
        return ownerEntity;
    }

    public void setOwnerEntity(MemoryHeader ownerEntity) {
        if (this.ownerEntity != null) {
            this.ownerEntity.setImageFile(null);
        }
        this.ownerEntity = ownerEntity;
        if (this.ownerEntity != null) {
            this.ownerEntity.setImageFile(this);
        }
    }
}
