package com.lifesoft.memoryhelp.model.core;

import java.io.Serializable;

/**
 * Class name: Description Purpose: defines the class Description Created on the
 * 11 avr. 2023 at 02:16:01 by Ste@lon
 *
 * @author Ste@lon
 */
public class Descriptor implements Serializable {
    private String description;

    public Descriptor() {
        super();
        description = "No description";
    }

    public Descriptor(String descriptionText) {
        super();
        this.description = descriptionText;
    }

    public String getText() {
        return description;
    }

    public void setText(String description) {
        this.description = description;
    }

    @Override
    public String toString(){
        return this.description;
    }
}
