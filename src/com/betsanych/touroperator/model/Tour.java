package com.betsanych.touroperator.model;

import com.betsanych.touroperator.base.Entity;

public class Tour extends Entity {

    private final String name;
    private final Country country;
    private final Hotel hotel;
    private final Guide guide;
    private final double price;

    public Tour(String name, Country country, Hotel hotel, Guide guide, double price) {
        this.name = name;
        this.country = country;
        this.hotel = hotel;
        this.guide = guide;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Country getCountry() {
        return country;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public Guide getGuide() {
        return guide;
    }

    public double getPrice() {
        return price;
    }
}
