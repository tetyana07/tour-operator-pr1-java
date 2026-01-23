package com.betsanych.touroperator.repository;

import com.betsanych.touroperator.base.Entity;
import com.betsanych.touroperator.specification.Specification;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class BaseRepository<T extends Entity> implements Repository<T, Long> {

    protected final List<T> storage = new ArrayList<>();

    @Override
    public T save(T entity) {
        deleteById(entity.getId());
        storage.add(entity);
        return entity;
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(storage);
    }

    @Override
    public void deleteById(Long id) {
        storage.removeIf(e -> e.getId().equals(id));
    }

    @Override
    public Optional<T> findById(Long id) {
        return storage.stream()
              .filter(e -> e.getId().equals(id))
              .findFirst();
    }

    @Override
    public boolean existsById(Long id) {
        return storage.stream().anyMatch(e -> e.getId().equals(id));
    }

    public List<T> findBySpecification(Specification<T> spec) {
        return storage.stream()
              .filter(spec::isSatisfiedBy)
              .toList();
    }

}
