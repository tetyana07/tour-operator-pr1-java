package com.betsanych.touroperator.service;

import com.betsanych.touroperator.dto.ClientLoginDto;
import com.betsanych.touroperator.dto.ClientRegisterDto;
import com.betsanych.touroperator.model.Client;
import com.betsanych.touroperator.repository.ClientRepository;

public class AuthService {

    private final ClientRepository clientRepository;
    private final EmailService emailService;

    public AuthService(ClientRepository clientRepository, EmailService emailService) {
        this.clientRepository = clientRepository;
        this.emailService = emailService;
    }

    public Client register(ClientRegisterDto dto) {
        if (clientRepository.findByEmail(dto.email()).isPresent()) {
            throw new IllegalStateException("Користувач з таким email вже існує");
        }
        Client client = new Client(dto.firstName(), dto.lastName(), dto.email(), dto.password());
        clientRepository.save(client);

        emailService.sendRegistrationEmail(dto.email());
        return client;
    }

    public Client login(ClientLoginDto dto) {
        return clientRepository.findByEmail(dto.email())
              .filter(c -> c.getPassword().equals(dto.password()))
              .orElseThrow(() -> new IllegalArgumentException("Невірний логін або пароль"));
    }


}
