package com.betsanych.touroperator.model;

import com.betsanych.touroperator.base.Entity;
import java.time.LocalDate;

public class Booking extends Entity {

    private final Client client;
    private final Tour tour;
    private final LocalDate date;
    private final int peopleCount;
    private String status;

    public Booking(Client client, Tour tour, LocalDate date, int peopleCount) {
        this.client = client;
        this.tour = tour;
        this.date = date;
        this.peopleCount = peopleCount;
        this.status = "CREATED";
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

    public int getPeopleCount() {
        return peopleCount;
    }

    public String getStatus() {
        return status;
    }

    // ✅ Бізнес-логіка всередині сутності
    public void cancel() {
        if ("CANCELLED".equals(status)) {
            throw new IllegalStateException("Бронювання вже скасоване");
        }
        this.status = "CANCELLED";
    }

    public void confirm() {
        if (!"CREATED".equals(status)) {
            throw new IllegalStateException("Можна підтвердити тільки нове бронювання");
        }
        this.status = "CONFIRMED";
    }
}
