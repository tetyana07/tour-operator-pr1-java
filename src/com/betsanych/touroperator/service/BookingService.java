package com.betsanych.touroperator.service;

import com.betsanych.touroperator.dto.BookingCreateDto;
import com.betsanych.touroperator.model.Booking;
import com.betsanych.touroperator.model.Client;
import com.betsanych.touroperator.model.Tour;
import com.betsanych.touroperator.repository.BookingRepository;
import com.betsanych.touroperator.repository.ClientRepository;
import com.betsanych.touroperator.repository.TourRepository;
import java.time.LocalDate;

public class BookingService {

    private final BookingRepository bookingRepository;
    private final ClientRepository clientRepository;
    private final TourRepository tourRepository;

    public BookingService(
          BookingRepository bookingRepository,
          ClientRepository clientRepository,
          TourRepository tourRepository
    ) {
        this.bookingRepository = bookingRepository;
        this.clientRepository = clientRepository;
        this.tourRepository = tourRepository;
    }

    /**
     * Створення бронювання
     */
    public Booking createBooking(BookingCreateDto dto) {

        Client client = clientRepository.findById(dto.clientId())
              .orElseThrow(() -> new IllegalArgumentException("Клієнт не знайдений"));

        Tour tour = tourRepository.findById(dto.tourId())
              .orElseThrow(() -> new IllegalArgumentException("Тур не знайдений"));

        if (dto.peopleCount() <= 0) {
            throw new IllegalArgumentException("Кількість людей має бути більшою за 0");
        }

        Booking booking = new Booking(
              client,
              tour,
              LocalDate.now(),
              dto.peopleCount()
        );

        bookingRepository.save(booking);
        return booking;
    }

    /**
     * Скасування бронювання
     */
    public void cancelBooking(long bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
              .orElseThrow(() -> new IllegalArgumentException("Бронювання не знайдено"));

        booking.cancel();   // ✅ БЕЗ параметрів
        bookingRepository.save(booking);
    }

    /**
     * Підтвердження бронювання
     */
    public void confirmBooking(long bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
              .orElseThrow(() -> new IllegalArgumentException("Бронювання не знайдено"));

        booking.confirm();  // ✅ БЕЗ параметрів
        bookingRepository.save(booking);
    }
}
