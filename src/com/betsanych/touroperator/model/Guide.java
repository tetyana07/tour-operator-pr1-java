package com.betsanych.touroperator.model;

import com.betsanych.touroperator.base.Entity;

public class Guide extends Entity {

    private final String name;
    private final String language;

    public Guide(String name, String language) {
        this.name = name;
        this.language = language;

    }

    public String getLanguage() {
        return language;
    }

    public String getName() {
        return name;
    }

}


