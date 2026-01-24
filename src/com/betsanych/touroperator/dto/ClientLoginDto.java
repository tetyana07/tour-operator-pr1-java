package com.betsanych.touroperator.dto;

public record ClientLoginDto(String email, String password) {

    public ClientLoginDto {
        if (email == null || password == null) {
            throw new IllegalArgumentException("Email і пароль обовʼязкові");
        }
    }
}
