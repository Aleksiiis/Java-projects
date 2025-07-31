package com.airline.main;

import com.airline.models.*;
import com.airline.models.Flight;
import com.airline.models.components.*;
import com.airline.services.AirlineCompany;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AirlineCompany company = initializeCompany();
        List<Flight> flights = initializeFlights(company); // Список рейсов
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
                case 6 -> handleShowFlights(flights); // Показать все рейсы
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

        // Первый самолет
        Airplane cargoJet = new Airplane(
                "Карго самолёт", "Москва", 500, "Понедельник",
                new Wing("Большое грузовое крыло"),
                new Chassis("Тяжелое шасси"),
                new Engine("Дизельный двигатель")
        );
        company.addAirplane(cargoJet);

        // Второй самолет
        Airplane passengerJet = new Airplane(
                "Пассажирский самолёт", "Лондон", 400, "Вторник",
                new Wing("Пассажирское крыло"),
                new Chassis("Легкое шасси"),
                new Engine("Реактивный двигатель")
        );
        company.addAirplane(passengerJet);

        // Третий самолет (RegionalJet)
        RegionalJet regionalJet = new RegionalJet(
                "RegionalJet", "Берлин", 350, "Среда",
                new Wing("Стандартное крыло"),
                new Chassis("Региональное шасси"),
                new Engine("Эффективный двигатель")
        );
        company.addAirplane(regionalJet);

        // Четвертый самолет (LongHaulJet)
        LongHaulJet longHaulJet = new LongHaulJet(
                "LongHaulJet", "Нью-Йорк", 700, "Пятница",
                new Wing("Крыло для дальних перелетов"),
                new Chassis("Шасси с усилением"),
                new Engine("Турбовентиляторный двигатель")
        );
        company.addAirplane(longHaulJet);

        return company;
    }

    private static List<Flight> initializeFlights(AirlineCompany company) {
        List<Flight> flights = new ArrayList<>();
        company.getAirplanes().forEach(airplane -> {
            if (airplane.getModel().equals("CargoJet")) {
                flights.add(new Flight((Airplane) airplane, "12:00"));
            } else if (airplane.getModel().equals("PassengerJet")) {
                flights.add(new Flight((Airplane) airplane, "15:30"));
            } else if (airplane.getModel().equals("RegionalJet")) {
                flights.add(new Flight((Airplane) airplane, "09:45"));
            } else if (airplane.getModel().equals("LongHaulJet")) {
                flights.add(new Flight((Airplane) airplane, "23:00"));
            }
        });

        return flights;
    }

    private static void showMenu() {
        System.out.println("\nМеню:");
        System.out.println("1. Показать все самолеты");
        System.out.println("2. Добавить самолет");
        System.out.println("3. Удалить самолет");
        System.out.println("4. Найти самолеты по месту назначения");
        System.out.println("5. Найти самолеты по дню недели");
        System.out.println("6. Показать все рейсы");
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

        company.addAirplane(new Airplane(
                model, destination, fuelConsumption, dayOfWeek,
                new Wing("Стандартное крыло"),
                new Chassis("Стандартное шасси"),
                new Engine("Стандартный двигатель")
        ));
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

    private static void handleShowFlights(List<Flight> flights) {
        System.out.println("Список рейсов:");
        flights.forEach(System.out::println);
    }
}
