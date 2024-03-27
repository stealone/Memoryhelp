package com.lifesoft.memoryhelp.model.memory;

import com.lifesoft.memoryhelp.model.core.Descriptor;
import com.lifesoft.memoryhelp.model.core.EntityCathegory;
import javafx.collections.FXCollections;

import java.io.Serial;
import java.util.List;

import static java.util.Comparator.comparing;

public class SubDomain extends MemoryHeader{
    @Serial
    private static final long serialVersionUID = 1L;

    private MemoDomain headerDomain;

    private List<ContentHeader> contentHeaderList;

    /**
     * Default Constructor
     *
     */
    public SubDomain() {
        super();
        this.entityCathegory = EntityCathegory.SUB_DOMAIN;
        contentHeaderList = FXCollections.observableArrayList();
    }

    /**
     *
     * @param entityName
     * @param descriptionText
     */
    public SubDomain(String entityName, String descriptionText) {
        super(entityName, descriptionText);
    }

    /**
     *
     * @param entityName the entity name
     * @param descriptor te entity descriptor
     */
    public SubDomain(String entityName, Descriptor descriptor) {
        super(entityName, descriptor);
        this.entityCathegory = EntityCathegory.SUB_DOMAIN;
        contentHeaderList = FXCollections.observableArrayList();
    }

    public SubDomain(Long id, String entityName, Descriptor descriptor) {
        super(id, entityName, descriptor);
        this.entityCathegory = EntityCathegory.SUB_DOMAIN;
        contentHeaderList = FXCollections.observableArrayList();
    }

    public SubDomain(final MemoDomain convertedDomain) {
        this(convertedDomain.getId(), convertedDomain.getEntityName(), convertedDomain.getDescription());
    }

    public List<ContentHeader> getContentHeaderList() {
        return contentHeaderList;
    }

    public void setContentHeaderList(List<ContentHeader> contentHeaderList) {
        this.contentHeaderList = FXCollections.observableArrayList(contentHeaderList);
        if (this.headerDomain.getContentDisplayOrder() == ContentDisplayOrder.NUMERICAL) {
            this.contentHeaderList.sort(comparing(ContentHeader::getOrderNumber));
        } else {
            this.contentHeaderList.sort(comparing(ContentHeader::getEntityName));
        }

    }

    public MemoDomain getHeaderDomain() {
        return headerDomain;
    }

    public void setHeaderDomain(MemoDomain domainParent) {
        if (this.headerDomain != null) {
            this.headerDomain.removeSubDomain(this);
        }
        this.headerDomain = domainParent;
        if (this.headerDomain != null) {
            this.headerDomain.addSubDomain(this);
        }
    }

    public boolean addContentHeader(ContentHeader newContentHeader) {
        if (!contentHeaderList.contains(newContentHeader)) {
            this.contentHeaderList.add(newContentHeader);
            if (this.headerDomain.getContentDisplayOrder() == ContentDisplayOrder.NUMERICAL) {
                this.contentHeaderList.sort(comparing(ContentHeader::getOrderNumber));
            } else {
                this.contentHeaderList.sort(comparing(ContentHeader::getEntityName));
            }
        }
        return contentHeaderList.contains(newContentHeader);
    }

    /**
     *
     * @param any
     * @return
     */
    public boolean removeContentHeader(ContentHeader any) {
        this.contentHeaderList.remove(any);
        return !this.contentHeaderList.contains(any);
    }

    /**
     *
     * @param contentHeader
     * @return
     */
    public boolean containsContentHeader(ContentHeader contentHeader) {
        return this.contentHeaderList.contains(contentHeader);
    }

    @Override
    public int getSubEntityCount() {
        subEntityCount = contentHeaderList.size();
        return subEntityCount;
    }

}
