package com.lifesoft.memoryhelp.model.memory;

import com.lifesoft.memoryhelp.model.core.Descriptor;
import com.lifesoft.memoryhelp.model.medias.ImageFile;

public abstract class MemoryHeader extends MemoryHelper{

    protected int subEntityCount;

    protected ContentDisplayOrder contentDisplayOrder;

    protected ImageFile imageFile;

    public MemoryHeader(){
        super();
    }

    public MemoryHeader(String entityName, Descriptor descriptor) {
        super(entityName, descriptor);
    }

    /**
     *
     * @param entityName the name of the entity
     * @param descriptionText the description text of the entity
     */
    public MemoryHeader(String entityName, String descriptionText) {
        super(entityName, descriptionText);
    }

    /**
     *
     * @param id the entity id
     * @param entityName the entity name
     * @param descriptor the entity descriptor
     */
    public MemoryHeader(Long id, String entityName, Descriptor descriptor) {
        super(id, entityName, descriptor);
    }


    public ImageFile getImageFile() {
        return imageFile;
    }

    public void setImageFile(ImageFile imageFile) {
        this.imageFile = imageFile;
    }

    public abstract int getSubEntityCount();

    public ContentDisplayOrder getContentDisplayOrder() {
        return contentDisplayOrder;
    }

    public void setContentDisplayOrder(ContentDisplayOrder contentDisplayOrder) {
        this.contentDisplayOrder = contentDisplayOrder;
    }
}
