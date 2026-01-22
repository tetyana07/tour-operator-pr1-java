package com.betsanych.touroperator.base;

public class Entity implements Identifiable {

    private final Long id;

    protected Entity() {
        this.id = System.nanoTime();
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Entity entity)) {
            return false;
        }
        return id.equals(entity.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
