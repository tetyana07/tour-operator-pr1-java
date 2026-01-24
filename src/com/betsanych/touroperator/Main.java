package com.betsanych.touroperator;

import com.betsanych.touroperator.dto.ClientLoginDto;
import com.betsanych.touroperator.dto.ClientRegisterDto;
import com.betsanych.touroperator.model.Client;
import com.betsanych.touroperator.repository.ClientRepository;
import com.betsanych.touroperator.service.AuthService;
import com.betsanych.touroperator.service.EmailService;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // 🔧 Ініціалізація інфраструктури
        ClientRepository clientRepository = new ClientRepository();
        EmailService emailService = new EmailService();
        AuthService authService = new AuthService(clientRepository, emailService);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("""
                  
                  ===== TOUR OPERATOR SYSTEM =====
                  1 — Реєстрація
                  2 — Вхід
                  0 — Вихід
                  """);

            System.out.print("Ваш вибір: ");
            String input = scanner.nextLine();

            try {
                switch (input) {
                    case "1" -> register(scanner, authService);
                    case "2" -> login(scanner, authService);
                    case "0" -> {
                        System.out.println("До побачення 👋");
                        return;
                    }
                    default -> System.out.println("Невірний вибір");
                }
            } catch (Exception e) {
                System.out.println("❌ Помилка: " + e.getMessage());
            }
        }
    }

    // =================== РЕЄСТРАЦІЯ ===================
    private static void register(Scanner scanner, AuthService authService) {

        System.out.print("Імʼя: ");
        String firstName = scanner.nextLine();

        System.out.print("Прізвище: ");
        String lastName = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Пароль: ");
        String password = scanner.nextLine();

        ClientRegisterDto dto = new ClientRegisterDto(
              email,
              password,
              firstName,
              lastName
        );

        Client client = authService.register(dto);
        System.out.println("✅ Реєстрація успішна! Вітаємо, " + client.getFirstname());
    }

    // =================== ВХІД ===================
    private static void login(Scanner scanner, AuthService authService) {

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Пароль: ");
        String password = scanner.nextLine();

        ClientLoginDto dto = new ClientLoginDto(email, password);

        Client client = authService.login(dto);
        System.out.println("✅ Вхід успішний! Вітаємо, " + client.getFirstname());
    }
}
