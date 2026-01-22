package com.betsanych.touroperator.model;

import com.betsanych.touroperator.base.Entity;
import java.time.LocalDate;

public class Booking extends Entity {

    private final Client client;
    private final Tour tour;
    private final LocalDate date;
    private final int peopleCont;

    public Booking(Client client, Tour tour, LocalDate date, int peopleCont) {
        this.client = client;
        this.tour = tour;
        this.date = date;
        this.peopleCont = peopleCont;
    }

    public Client getClient() {
        return client;
    }

    public Tour getTour() {
        return tour;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getPeopleCont() {
        return peopleCont;
    }
}
