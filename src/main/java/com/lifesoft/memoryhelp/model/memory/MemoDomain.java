package com.lifesoft.memoryhelp.model.memory;

import com.lifesoft.memoryhelp.model.core.Descriptor;
import com.lifesoft.memoryhelp.model.core.EntityCathegory;
import javafx.collections.FXCollections;

import java.io.Serial;
import java.util.List;

import static java.util.Comparator.comparing;

public class MemoDomain extends MemoryHeader{
    @Serial
    private static final long serialVersionUID = 1L;

    private List<SubDomain> subDomainList;

    /**
     * Default Constructor
     *
     */
    public MemoDomain() {
        super();
        this.entityCathegory = EntityCathegory.DOMAIN;
        subDomainList = FXCollections.observableArrayList();
    }

    /**
     *
     * @param entityName the entity name
     * @param descriptor the entity descriptor
     */
    public MemoDomain(String entityName, Descriptor descriptor) {
        super(entityName, descriptor);
        this.entityCathegory = EntityCathegory.DOMAIN;
        subDomainList = FXCollections.observableArrayList();
    }

    /**
     *
     * @param entityName the entity name
     * @param descriptionText the description text
     */
    public MemoDomain(String entityName, String descriptionText) {
        super(entityName, descriptionText);
    }

    public MemoDomain(Long id, String entityName, Descriptor descriptor) {
        super(id, entityName, descriptor);
        this.entityCathegory = EntityCathegory.DOMAIN;
        subDomainList = FXCollections.observableArrayList();
    }

    public MemoDomain(final SubDomain promotedSubDomain) {
        this(promotedSubDomain.getId(), promotedSubDomain.getEntityName(), promotedSubDomain.getDescription());
    }

    public boolean addSubDomain(SubDomain newSubDomain) {
        boolean isAdded = false;
        if (!subDomainList.contains(newSubDomain)) {
            isAdded = this.subDomainList.add(newSubDomain);
            if (contentDisplayOrder == ContentDisplayOrder.NUMERICAL) {
                subDomainList.sort(comparing(SubDomain::getOrderNumber));
            } else {
                subDomainList.sort(comparing(SubDomain::getEntityName));
            }
        }
        return isAdded;
    }

    public List<SubDomain> getSubDomainList() {
        return subDomainList;
    }

    public void setSubDomainList(List<SubDomain> subDomainList) {
        this.subDomainList = FXCollections.observableArrayList(subDomainList);
        if (contentDisplayOrder == ContentDisplayOrder.NUMERICAL) {
            subDomainList.sort(comparing(SubDomain::getOrderNumber));
        } else {
            subDomainList.sort(comparing(SubDomain::getEntityName));
        }
    }

    /**
     *
     * @param oldSubDomain the old subdomain to be removed
     * @return true or false
     */
    public boolean removeSubDomain(SubDomain oldSubDomain) {
        boolean isRemoved = false;
        if (subDomainList.contains(oldSubDomain)) {
            isRemoved = subDomainList.remove(oldSubDomain);
        }
        return isRemoved;
    }

    /**
     *
     * @param subdomain the subdomain to be checked
     * @return true if present or false otherwise
     */
    public boolean containsSubDomain(SubDomain subdomain) {
        return this.subDomainList.contains(subdomain);
    }

    @Override
    public int getSubEntityCount() {
        subEntityCount = subDomainList.size();
        return subEntityCount;
    }
}
