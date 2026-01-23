package com.betsanych.touroperator.specification;

import com.betsanych.touroperator.model.Tour;

public class TourSpecifications {

    public static Specification<Tour> priceLessThan(double maxPrice) {
        return tour -> tour.getPrice() < maxPrice;

    }

    public static Specification<Tour> byCountry(String countryName) {
        return tour -> tour.getCountry().getName().equalsIgnoreCase(countryName);
    }
}
