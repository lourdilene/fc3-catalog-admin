package com.fullcycle.catalog.admin.infrastructure;

import com.fullcycle.catalog.admin.application.UseCase;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Word!");

        System.out.println(new UseCase().execute());
    }
}