package com.betsanych.touroperator.model;

import com.betsanych.touroperator.base.Entity;

public class Country extends Entity {

    private final String name;

    public Country(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
