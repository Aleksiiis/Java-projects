package com.airline.main;

import com.airline.models.*;
import com.airline.services.AirlineCompany;
import com.airline.models.components.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AirlineCompany company = initializeCompany();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            showMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> company.getAirplanes().forEach(System.out::println);
                case 2 -> addAirplane(company, scanner);
                case 3 -> removeAirplane(company, scanner);
                case 4 -> findAirplanesByDestination(company, scanner);
                case 5 -> findAirplanesByDay(company, scanner);
                case 0 -> {
                    System.out.println("Выход.");
                    return;
                }
                default -> System.out.println("Неверный ввод. Попробуйте снова.");
            }
        }
    }

    private static AirlineCompany initializeCompany() {
        AirlineCompany company = new AirlineCompany();
        company.addAirplane(new CargoAirplane("CargoJet", "Москва", 500, "Понедельник"

        ));
        company.addAirplane(new PassengerAirplane("PassengerJet", "Лондон", 400, "Вторник"

        ));
        return company;
    }

    private static void showMenu() {
        System.out.println("\nМеню:");
        System.out.println("1. Показать все самолеты");
        System.out.println("2. Добавить самолет");
        System.out.println("3. Удалить самолет");
        System.out.println("4. Найти самолеты по месту назначения");
        System.out.println("5. Найти самолеты по дню недели");
        System.out.println("0. Выход");
        System.out.print("Выберите опцию: ");
    }

    private static void addAirplane(AirlineCompany company, Scanner scanner) {
        System.out.print("Введите модель: ");
        String model = scanner.next();
        System.out.print("Введите место назначения: ");
        String destination = scanner.next();
        System.out.print("Введите расход топлива: ");
        int fuelConsumption = scanner.nextInt();
        System.out.print("Введите день недели: ");
        String dayOfWeek = scanner.next();

        Wing wing = new Wing("Стандартное крыло");
        Chassis chassis = new Chassis("Стандартное шасси");
        Engine engine = new Engine("Стандартный двигатель");

        company.addAirplane(new CargoAirplane(model, destination, fuelConsumption, dayOfWeek));
    }

    private static void removeAirplane(AirlineCompany company, Scanner scanner) {
        System.out.print("Введите модель самолета для удаления: ");
        String model = scanner.next();
        company.removeAirplane(model);
        System.out.println("Самолет удален.");
    }

    private static void findAirplanesByDestination(AirlineCompany company, Scanner scanner) {
        System.out.print("Введите место назначения: ");
        String destination = scanner.next();

        company.findAirplanesByDestination(destination).forEach(System.out::println);
    }

    private static void findAirplanesByDay(AirlineCompany company, Scanner scanner) {
        System.out.print("Введите день недели: ");
        String dayOfWeek = scanner.next();

        company.findAirplanesByDay(dayOfWeek).forEach(System.out::println);
    }
}
