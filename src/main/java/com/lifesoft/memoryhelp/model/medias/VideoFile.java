package com.lifesoft.memoryhelp.model.medias;

import com.lifesoft.memoryhelp.model.memory.Note;

public class VideoFile extends MultimediaFile{

    private Note ownerEntity;

    public Note getOwnerEntity() {
        return ownerEntity;
    }

    public void setOwnerEntity(Note ownerEntity) {
        if(this.ownerEntity != null){
            this.ownerEntity.removeVideo(this);
        }
        this.ownerEntity = ownerEntity;
        if(this.ownerEntity != null){
            this.ownerEntity.addVideo(this);
        }
    }
}
