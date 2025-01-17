package com.fullcycle.catalog.admin.domain.category;

import com.fullcycle.catalog.admin.domain.validation.Error;
import com.fullcycle.catalog.admin.domain.validation.ValidationHandler;
import com.fullcycle.catalog.admin.domain.validation.Validator;

public class CategoryValidator extends Validator{
    public static final int NAME_MAX_LENGTH = 255;
    public static final int NAME_MIN_LENGTH = 3;
    private final Category category;

    protected CategoryValidator(final Category category, ValidationHandler ahandler) {
        super(ahandler);
        this.category = category;
    }

    @Override
    public void validate() {
        checkNameConstraints();
    }

    private void checkNameConstraints() {
        final var name = this.category.getName();
        if (name == null){
            this.validationHandler().append(new Error("'name' should not be null"));
        }
        if (name.isBlank()){
            this.validationHandler().append(new Error("'name' should not be empty"));
        }
        final int length = name.trim().length();
        if (length>NAME_MAX_LENGTH || length<NAME_MIN_LENGTH){
            this.validationHandler().append(new Error("'name' must be between 3 and 255 characters."));
        }
    }
}
