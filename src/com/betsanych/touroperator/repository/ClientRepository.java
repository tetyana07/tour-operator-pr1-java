package com.betsanych.touroperator.repository;

import com.betsanych.touroperator.model.Client;
import java.util.Optional;

public class ClientRepository extends BaseRepository<Client> {

    public Optional<Client> findByEmail(String email) {
        return findAll().stream()
              .filter(client -> client.getEmail().equalsIgnoreCase(email))
              .findFirst();
    }
}
