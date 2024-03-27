package com.lifesoft.memoryhelp.model.memory;

import com.lifesoft.memoryhelp.model.medias.Illustration;
import com.lifesoft.memoryhelp.model.medias.VideoFile;
import javafx.collections.FXCollections;

import java.util.List;

public class Note extends MemoryContent{
    private final List<Illustration> illustrationList = FXCollections.observableArrayList();
    private final List<VideoFile> videoList = FXCollections.observableArrayList();

    public boolean removeIllustration(Illustration illustration) {
        if(illustrationList.contains(illustration)){
            return this.illustrationList.remove(illustration);
        }
        return false;
    }

    public boolean addIllustration(Illustration illustration) {
        if(!illustrationList.contains(illustration)){
            return this.illustrationList.add(illustration);
        }
        return false;
    }

    public boolean containsIllustration(Illustration anyIllustration){
        return this.illustrationList.contains(anyIllustration);
    }

    public boolean removeVideo(VideoFile videoFile) {
        if(videoList.contains(videoFile)){
            return this.videoList.remove(videoFile);
        }
        return false;
    }

    public boolean addVideo(VideoFile videoFile) {
        if(!videoList.contains(videoFile)){
            return this.videoList.add(videoFile);
        }
        return false;
    }

    public boolean containsVideo(VideoFile videoFile){
        return  this.videoList.contains(videoFile);
    }
}
