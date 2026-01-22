package com.betsanych.touroperator.model;

import com.betsanych.touroperator.base.Entity;

public class Client extends Entity {

    private final String lastname;
    private final String firstname;
    private final String email;
    private final String phone;


    public Client(String lastname, String firstname, String email, String phone) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.phone = phone;

        if (firstname == null || firstname.isBlank()) {
            throw new IllegalArgumentException("First name is required");
        }
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Email is invalid");
        }
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

}
