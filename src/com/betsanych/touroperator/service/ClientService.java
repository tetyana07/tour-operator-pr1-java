package com.betsanych.touroperator.service;

import com.betsanych.touroperator.model.Client;
import com.betsanych.touroperator.repository.ClientRepository;
import java.util.List;

public class ClientService {

    private final ClientRepository repository;

    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    public List<Client> getAllClients() {
        return repository.findAll();
    }

    public Client getClientById(long id) {
        return repository.findById(id)
              .orElseThrow(() -> new IllegalArgumentException("Клієнт не знайдений"));
    }

}
