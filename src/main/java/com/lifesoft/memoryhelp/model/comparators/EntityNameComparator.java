package com.lifesoft.memoryhelp.model.comparators;

import com.lifesoft.memoryhelp.model.core.GenericEntity;

import java.util.Comparator;

public class EntityNameComparator<T extends GenericEntity> implements EntityComparator<T> {

    public EntityNameComparator(){
        super();
    }

    @Override
    public Comparator<T> getComparator(){
        var com = Comparator.comparing(GenericEntity::getId)
                .thenComparing(GenericEntity::getEntityName)
                .thenComparing(GenericEntity::getCreationDate);
        return (Comparator<T>) com;
    }
}
