package com.betsanych.touroperator.dto;

public record BookingCreateDto(
      long clientId,
      long tourId,
      int peopleCount
) {

    public BookingCreateDto {
        if (peopleCount <= 0) {
            throw new IllegalArgumentException("Кількість людей має бути > 0");
        }
    }
}
