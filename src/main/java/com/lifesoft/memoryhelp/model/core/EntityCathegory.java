package com.lifesoft.memoryhelp.model.core;

public enum EntityCathegory {
    DOMAIN(0), SUB_DOMAIN(1), CONTENT_HEADER(2), CONTENT(3);

    private final int displayerIndex;

    EntityCathegory(int displayerIndex) {
        this.displayerIndex = displayerIndex;
    }

    public int getDisplayerIndex() {
        return this.displayerIndex;
    }

}
