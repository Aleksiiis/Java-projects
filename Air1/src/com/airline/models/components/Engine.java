package com.airline.models.components;

public class Engine {
    private String model;

    public Engine(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Двигатель: " + model;
    }
}
