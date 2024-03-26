package com.lifesoft.memoryhelp.model.core;


import com.lifesoft.memoryhelp.model.comparators.EntityComparator;
import com.lifesoft.memoryhelp.model.comparators.EntityNameComparator;
import org.jetbrains.annotations.NotNull;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class GenericEntity implements Serializable, Comparable<GenericEntity>{

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;

    protected String entityName;

    protected Descriptor Descriptor;

    protected LocalDate creationDate;

    protected transient int orderNumber;

    private boolean updated = false;

    protected transient boolean selected;

    protected EntityComparator entityComparator;

    /*
     * Default constructor
     *
     */
    public GenericEntity() {
        super();
        this.creationDate = LocalDate.now();
        this.entityComparator = new EntityNameComparator();
    }

    /**
     *
     * @param entityName
     * @param Descriptor
     */
    public GenericEntity(String entityName, Descriptor Descriptor) {
        this();
        this.entityName = entityName;
        this.Descriptor = Descriptor;
    }

    /**
     *
     * @param entityName
     * @param descriptionText
     */
    public GenericEntity(String entityName, String descriptionText) {
        this();
        this.entityName = entityName;
        this.Descriptor = new Descriptor(descriptionText);
    }

    /**
     *
     * @param id
     * @param entityName
     * @param Descriptor
     */
    public GenericEntity(Long id, String entityName, Descriptor Descriptor) {
        this(entityName, Descriptor);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public Descriptor getDescription() {
        return Descriptor;
    }

    public void setDescription(Descriptor Descriptor) {
        this.Descriptor = Descriptor;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     * The method tells us if the object has been persisted already. the entity
     * being persisted is assigned an id. So if the entity id is not null, the
     * entity can then be considered as persisted.
     *
     * @return true if the entity id is not null and false otherwise.
     */
    public boolean isPersisted() {
        return Objects.nonNull(this.id);
    }

    public boolean isUpdated() {
        return updated;
    }

    public void setUpdated(boolean updated) {
        this.updated = updated;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public void setEntityComparator(EntityComparator entityComparator) {
        this.entityComparator = entityComparator;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.entityName);
        hash = 53 * hash + Objects.hashCode(this.creationDate);
        hash = 53 * hash + this.orderNumber;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GenericEntity other = (GenericEntity) obj;
        if (this.orderNumber != other.orderNumber) {
            return false;
        }
        if (!Objects.equals(this.entityName, other.entityName)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.creationDate, other.creationDate);
    }

    @Override
    public String toString() {
        return this.entityName;
    }

    @Override
    public int compareTo(@NotNull GenericEntity entity) {
        return this.entityComparator.getComparator().compare(this, entity);
    }
}
