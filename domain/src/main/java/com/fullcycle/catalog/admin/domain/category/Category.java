package com.fullcycle.catalog.admin.domain.category;

import com.fullcycle.catalog.admin.domain.AggregateRoot;
import com.fullcycle.catalog.admin.domain.utils.InstantUtils;
import com.fullcycle.catalog.admin.domain.validation.ValidationHandler;

import java.time.Instant;
import java.util.UUID;

public class Category extends AggregateRoot<CategoryID> {
    private String name;
    private String description;
    private boolean active;
    private Instant createdAt;
    private Instant updatedAt;
    private Instant deletedAt;

    private Category(final CategoryID anId,
                     final String aName,
                     final String aDescription,
                     final boolean isActive,
                     final Instant aCreatedAt,
                     final Instant anUpdatedAt,
                     final Instant aDeletedAt) {
        super(anId);
        this.name = aName;
        this.description = aDescription;
        this.active = isActive;
        this.createdAt = aCreatedAt;
        this.updatedAt = anUpdatedAt;
        this.deletedAt = aDeletedAt;
    }

    public static Category newCategory(final String aName,
                                       final String aDescription,
                                       final boolean aIsActive){
        final var id = CategoryID.unique();
        final var now = InstantUtils.now();

        return new Category(id, aName, aDescription, aIsActive, now, now, null);
    }

//    public static Category with(
//            final CategoryID anId,
//            final String name,
//            final String description,
//            final boolean active,
//            final Instant createdAt,
//            final Instant updatedAt,
//            final Instant deletedAt
//    ){
//        return new Category(
//                anId,
//                name,
//                description,
//                active,
//                createdAt,
//                updatedAt,
//                deletedAt
//        );
//    }
//
//    public static Category with(
//            final Category aCategory
//    ){
//        return with(
//                aCategory.getId(),
//                aCategory.getName(),
//                aCategory.getDescription(),
//                aCategory.getActive(),
//                aCategory.getCreatedAt(),
//                aCategory.getUpdatedAt(),
//                aCategory.getDeletedAt()
//        );
//    }

    @Override
    public void validate(final ValidationHandler handler) {
        new CategoryValidator(this,handler).validate();
    }

    public Category activate() {
        this.deletedAt = null;
        this.active = true;
        this.updatedAt = InstantUtils.now();
        return this;
    }

    public Category deactivate() {
        if (getDeletedAt() == null) {
            this.deletedAt = InstantUtils.now();
        }

        this.active = false;
        this.updatedAt = InstantUtils.now();
        return this;
    }

    public Category update(
            final String aName,
            final String aDescription,
            final boolean isActive
    ) {
        if (isActive) {
            activate();
        } else {
            deactivate();
        }
        this.name = aName;
        this.description = aDescription;
        this.updatedAt = Instant.now();
        return this;
    }

    public CategoryID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean getActive() {
        return active;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public Instant getDeletedAt() {
        return deletedAt;
    }

//    @Override
//    public Category clone() {
//        try {
//            return (Category) super.clone();
//        } catch (CloneNotSupportedException e) {
//            throw new AssertionError();
//        }
//    }
}
