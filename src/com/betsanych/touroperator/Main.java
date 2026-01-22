package com.betsanych.touroperator;

import com.betsanych.touroperator.base.LocalDateAdapter;
import com.betsanych.touroperator.model.Booking;
import com.betsanych.touroperator.model.Client;
import com.betsanych.touroperator.model.Country;
import com.betsanych.touroperator.model.Guide;
import com.betsanych.touroperator.model.Hotel;
import com.betsanych.touroperator.model.Tour;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Country country = new Country("Italy");

        Hotel hotel = new Hotel("Roma Hotel", 5, country);

        Guide guide = new Guide("Mario", "English");

        Tour tour = new Tour("Rome Tour", country, hotel, guide, 1200.0);

        Client client = new Client(
              "Ivanova",
              "Anna",
              "anna@gmail.com",
              "+380991112233"
        );

        List<Booking> bookings = new ArrayList<>();

        Booking booking = new Booking(
              client,
              tour,
              LocalDate.now(),
              2
        );

        bookings.add(booking);

        Gson gson = new GsonBuilder()
              .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
              .setPrettyPrinting()
              .create();

        try (FileWriter writer = new FileWriter("bookings.json")) {
            gson.toJson(bookings, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Файл bookings.json створено");

    }
}




