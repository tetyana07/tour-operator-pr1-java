package com.betsanych.touroperator;

import com.betsanych.touroperator.model.Country;
import com.betsanych.touroperator.model.Guide;
import com.betsanych.touroperator.model.Hotel;
import com.betsanych.touroperator.model.Tour;
import com.betsanych.touroperator.repository.JsonRepository;
import com.betsanych.touroperator.repository.TourRepository;

public class Main {

    public static void main(String[] args) {

        TourRepository tourRepo = new TourRepository();

        Country italy = new Country("Італія");
        Hotel hotel = new Hotel("Готель Рома", 4, italy);
        Guide guide = new Guide("Маріо", "EN");

        Tour tour1 = new Tour("Подорож до Риму", italy, hotel, guide, 1200);
        Tour tour2 = new Tour("Дешева подорож до Риму", italy, hotel, guide, 800);

        tourRepo.save(tour1);
        tourRepo.save(tour2);

        JsonRepository<Tour> jsonRepo =
              new JsonRepository<>("tours.json");

        jsonRepo.saveToFile(tourRepo.findAll());

        System.out.println("Виконано ✔");
    }
}
