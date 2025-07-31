package com.airline.models;

import com.airline.interfaces.AirInterface;

public abstract class AbstractAirplane implements AirInterface {
    private String model;            // Модель самолета
    private String destination;      // Место назначения (город)
    private int fuelConsumption;     // Расход топлива
    private String dayOfWeek;        // День недели

    public AbstractAirplane(String model, String destination, int fuelConsumption, String dayOfWeek) {
        this.model = model;
        this.destination = destination;
        this.fuelConsumption = fuelConsumption;
        this.dayOfWeek = dayOfWeek;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public String getDestination() {
        return destination;
    }

    @Override
    public int getFuelConsumption() {
        return fuelConsumption;
    }

    @Override
    public String getDayOfWeek() {
        return dayOfWeek;
    }

    @Override
    public String toString() {
        return model + ": [Назначение: " + destination + ", Расход топлива: " + fuelConsumption +
                ", День недели: " + dayOfWeek + "]";
    }
}
