package com.lifesoft.memoryhelp.model.memory;

import com.lifesoft.memoryhelp.model.core.Descriptor;
import com.lifesoft.memoryhelp.model.core.GenericEntity;
import com.lifesoft.memoryhelp.model.core.MemoryHelpEntity;

public class MemoryHelper extends MemoryHelpEntity {

    public MemoryHelper(){
        super();
    }

    public MemoryHelper(String entityName, Descriptor descriptor) {
        super(entityName, descriptor);
    }

    /**
     *
     * @param entityName
     * @param descriptionText
     */
    public MemoryHelper(String entityName, String descriptionText) {
        super(entityName, descriptionText);
    }

    /**
     *
     * @param id
     * @param entityName
     * @param descriptor
     */
    public MemoryHelper(Long id, String entityName, Descriptor descriptor) {
        super(id, entityName, descriptor);
    }

}
