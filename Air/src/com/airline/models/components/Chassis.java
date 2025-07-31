package com.airline.models.components;

public class Chassis {
    private String type;

    public Chassis(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Шасси: " + type;
    }
}
