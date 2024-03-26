package com.lifesoft.memoryhelp.model.comparators;

import com.lifesoft.memoryhelp.model.core.GenericEntity;

import java.util.Comparator;

public class OrderNumberComparator <T extends GenericEntity> implements EntityComparator<T>{

    public OrderNumberComparator(){
        super();
    }

    @Override
    public Comparator<T> getComparator(){
        var com = Comparator.comparing(GenericEntity::getId)
                .thenComparing(GenericEntity::getCreationDate)
                .thenComparingInt(GenericEntity::getOrderNumber);
        return (Comparator<T>) com;
    }
}
