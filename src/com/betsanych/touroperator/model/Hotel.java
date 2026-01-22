package com.betsanych.touroperator.model;

import com.betsanych.touroperator.base.Entity;

public class Hotel extends Entity {

    private final String name;
    private final int stars;
    private final Country country;

    public Hotel(String name, int stars, Country country) {
        this.name = name;
        this.stars = stars;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public int getStars() {
        return stars;
    }

    public Country getCountry() {
        return country;
    }
}

