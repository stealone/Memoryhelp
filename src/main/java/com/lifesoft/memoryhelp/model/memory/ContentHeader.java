package com.lifesoft.memoryhelp.model.memory;

import com.lifesoft.memoryhelp.model.comparators.OrderNumberComparator;
import com.lifesoft.memoryhelp.model.core.Descriptor;
import com.lifesoft.memoryhelp.model.core.EntityCathegory;
import com.lifesoft.memoryhelp.model.core.GenericEntity;
import javafx.collections.FXCollections;

import java.text.Collator;
import java.util.List;
import java.util.Objects;

import static java.util.Comparator.comparing;

public class ContentHeader extends MemoryHeader{
    private SubDomain headerSubDomain;

    private List<Note> noteList;

    /**
     *
     */
    public ContentHeader() {
        super();
        this.entityCathegory = EntityCathegory.CONTENT;
        noteList = FXCollections.observableArrayList();
        this.entityComparator = new OrderNumberComparator();
    }

    /**
     *
     * @param entityName
     * @param descriptionText
     */
    public ContentHeader(String entityName, String descriptionText) {
        super(entityName, descriptionText);
    }

    /**
     *
     * @param entityName the entityName
     * @param descriptor  the entity descriptor
     */
    public ContentHeader(String entityName, Descriptor descriptor) {
        super(entityName, descriptor);
        this.entityCathegory = EntityCathegory.CONTENT;
        this.noteList = FXCollections.observableArrayList();
        this.entityComparator = new OrderNumberComparator();
    }

    public void setParentSubDomain(final SubDomain  newHeaderSubDomain) {
        if (Objects.nonNull(this.headerSubDomain)) {
            this.headerSubDomain.removeContentHeader(this);
        }
        this.headerSubDomain = newHeaderSubDomain;

        if (Objects.nonNull(this.headerSubDomain)) {
            this.headerSubDomain.addContentHeader(this);
        }
    }

    public SubDomain getHeaderSubDomain() {
        return headerSubDomain;
    }

    public List<Note> getNoteList() {
        return noteList;
    }

    public void setNoteList(List<Note> noteList) {
        this.noteList = FXCollections.observableArrayList(noteList);
        if (this.headerSubDomain.getContentDisplayOrder() == ContentDisplayOrder.NUMERICAL) {
            this.noteList.sort(comparing(note -> note.getOrderNumber()));
        } else {
            this.noteList.sort(comparing(note -> note.getEntityName()));
        }
    }

    public boolean addNote(Note newNote) {
        if (!noteList.contains(newNote)) {
            this.noteList.add(newNote);
            if (this.headerSubDomain.getContentDisplayOrder() == ContentDisplayOrder.NUMERICAL) {
                this.noteList.sort(comparing(note -> note.getOrderNumber()));
            } else {
                this.noteList.sort(comparing(note -> note.getEntityName()));
            }
        }
        return noteList.contains(newNote);
    }

    public boolean removeNote(Note oldNote) {
        if (noteList.contains(oldNote)) {
            return this.noteList.remove(oldNote);
        }
        return false;
    }

    public boolean containsNote(Note note) {
        return this.noteList.contains(note);
    }

    @Override
    public int getSubEntityCount() {
        subEntityCount = noteList.size();
        return noteList.size();
    }

    @Override
    public int compareTo(GenericEntity entity) {
        Collator comp = Collator.getInstance();
        if (this.headerSubDomain.getContentDisplayOrder() == ContentDisplayOrder.NUMERICAL) {
            return comp.compare(this.orderNumber, entity.getOrderNumber());
        } else {
            return comp.compare(this.entityName, entity.getEntityName());
        }
    }

}
