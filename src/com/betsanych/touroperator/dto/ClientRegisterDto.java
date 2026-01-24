package com.betsanych.touroperator.dto;

public record ClientRegisterDto(String email, String password, String firstName, String lastName) {

    public ClientRegisterDto {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Некоректний email");
        }
        if (password == null || password.length() < 6) {
            throw new IllegalArgumentException("Пароль має містити мінімум 6 символів");
        }
        if (firstName == null || firstName.isBlank()) {
            throw new IllegalArgumentException("Імʼя обовʼязкове");
        }
        if (lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException("Прізвище обовʼязкове");
        }
    }

    public String password() {
        return password;
    }

    public String firstName() {
        return firstName;
    }

    public String lastName() {
        return lastName;
    }

    public String email() {
        return email;
    }
}


