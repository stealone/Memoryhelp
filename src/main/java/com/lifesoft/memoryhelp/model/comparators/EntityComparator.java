package com.lifesoft.memoryhelp.model.comparators;

import com.lifesoft.memoryhelp.model.core.GenericEntity;

import java.util.Comparator;

public interface EntityComparator<T extends GenericEntity> {
    Comparator<T> getComparator();
}
