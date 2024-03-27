package com.lifesoft.memoryhelp.model.core;

public abstract class MemoryHelpEntity extends GenericEntity{
    protected EntityCathegory entityCathegory;

    protected transient boolean loaded;


    /**
     * Default constructor
     *
     */
    public MemoryHelpEntity() {
        super();
        loaded = false;
    }

    /**
     *
     * @param entityName
     * @param descriptor
     */
    public MemoryHelpEntity(String entityName, Descriptor descriptor) {
        super(entityName, descriptor);
        loaded = false;
    }

    /**
     *
     * @param entityName
     * @param descriptionText
     */
    public MemoryHelpEntity(String entityName, String descriptionText) {
        super(entityName, descriptionText);
        loaded = false;
    }

    public MemoryHelpEntity(Long id, String entityName, Descriptor descriptor) {
        super(id, entityName, descriptor);
        loaded = false;
    }
    /**
     *
     * @return
     */
    public EntityCathegory getEntityCathegory() {
        return entityCathegory;
    }

    public boolean isLoaded() {
        return loaded;
    }

    public void setLoaded(boolean loaded) {
        this.loaded = loaded;
    }
}
