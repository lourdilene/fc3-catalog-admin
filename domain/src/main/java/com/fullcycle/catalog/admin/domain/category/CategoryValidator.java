package com.fullcycle.catalog.admin.domain.category;

import com.fullcycle.catalog.admin.domain.validation.ValidationHandler;
import com.fullcycle.catalog.admin.domain.validation.Validator;

public class CategoryValidator extends Validator{
    private final Category category;

    protected CategoryValidator(final Category category, ValidationHandler ahandler) {
        super(ahandler);
        this.category = category;
    }

    @Override
    public void validate() {

    }
}
