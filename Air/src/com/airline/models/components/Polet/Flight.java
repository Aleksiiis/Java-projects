package com.airline.models;

public class Flight {
    private Airplane airplane;     // Самолет
    private String destination;    // Направление
    private String departureTime;  // Время вылета

    public Flight(Airplane airplane, String departureTime) {
        this.airplane = airplane;
        this.destination = airplane.getDestination(); // Использование Airplane
        this.departureTime = departureTime;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public String getDestination() {
        return destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    @Override
    public String toString() {
        return "Рейс: [Самолет: " + airplane.getModel() +
                ", Направление: " + destination +
                ", Время вылета: " + departureTime +
                ", Детали самолета: " + airplane + "]";
    }
}
