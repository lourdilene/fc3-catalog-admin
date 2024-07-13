package com.fullcycle.catalog.admin.application;

import com.fullcycle.catalog.admin.domain.Category;

public class UseCase {
    public Category execute(){
        return new Category();
    }
}