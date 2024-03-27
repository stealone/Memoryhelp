package com.lifesoft.memoryhelp.model.memory;

import com.lifesoft.memoryhelp.model.core.Descriptor;

public abstract class MemoryContent extends MemoryHelper{
    public MemoryContent() {
        super();
    }

    public MemoryContent(String entityName, Descriptor descriptor) {
        super(entityName, descriptor);
    }

    public MemoryContent(Long id, String entityName, Descriptor descriptor) {
        super(id, entityName, descriptor);
    }
}
