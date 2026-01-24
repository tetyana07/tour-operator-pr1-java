package com.betsanych.touroperator.model;

import com.betsanych.touroperator.base.Entity;

public class Client extends Entity {

    private final String lastname;
    private final String firstname;
    private final String email;
    private final String phone;
    private final String password;

    public Client(
          String firstname,
          String lastname,
          String email,
          String password
    ) {
        if (firstname == null || firstname.isBlank()) {
            throw new IllegalArgumentException("Прізвище є обовязковим");
        }
        if (lastname == null || lastname.isBlank()) {
            throw new IllegalArgumentException("Імя є обовязковим");
        }
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Email неправильний");
        }
        if (password == null || password.length() < 6) {
            throw new IllegalArgumentException("Пароль дуже короткий");
        }

        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.phone = null;
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

    public String getPassword() {
        return password;
    }
}
