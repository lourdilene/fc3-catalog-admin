package com.fullcycle.catalog.admin.domain.validation;

public abstract class Validator {
    private final ValidationHandler handler;

    protected Validator(ValidationHandler ahandler) {
        this.handler = ahandler;
    }

    public abstract void validate();

    protected ValidationHandler validationHandler(){
        return this.handler;
    }
}
