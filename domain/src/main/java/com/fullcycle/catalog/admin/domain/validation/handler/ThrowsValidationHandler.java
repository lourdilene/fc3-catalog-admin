package com.fullcycle.catalog.admin.domain.validation.handler;

import com.fullcycle.catalog.admin.domain.validation.Error;
import com.fullcycle.catalog.admin.domain.validation.ValidationHandler;

import java.util.List;

public class ThrowsValidationHandler implements ValidationHandler {
    @Override
    public ValidationHandler append(Error anError) {
        return null;
    }

    @Override
    public ValidationHandler append(ValidationHandler anHandler) {
        return null;
    }

    @Override
    public ValidationHandler validate(Validation aValidation) {
        return null;
    }

    @Override
    public List<Error> getErrors() {
        return List.of();
    }
}
