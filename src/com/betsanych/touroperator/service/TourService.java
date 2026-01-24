package com.betsanych.touroperator.service;

import com.betsanych.touroperator.model.Tour;
import com.betsanych.touroperator.repository.TourRepository;
import com.betsanych.touroperator.specification.Specification;
import java.util.List;

public class TourService {

    private final TourRepository repository;

    public TourService(TourRepository tourRepository) {
        this.repository = tourRepository;
    }

    public List<Tour> findAll() {
        return repository.findAll();
    }

    public List<Tour> findBySpecification(Specification<Tour> spec) {
        return repository.findBySpecification(spec);
    }

    public Tour getById(long id) {
        return repository.findById(id)
              .orElseThrow(() -> new IllegalArgumentException("Тур не знайдений"));
    }

}
