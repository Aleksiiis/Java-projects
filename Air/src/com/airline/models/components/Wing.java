package com.airline.models.components;

public class Wing {
    private String type;

    public Wing(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Крыло: " + type;
    }
}
