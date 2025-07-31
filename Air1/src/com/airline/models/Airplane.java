package com.airline.models;

import com.airline.models.components.Chassis;
import com.airline.models.components.Engine;
import com.airline.models.components.Wing;

public class Airplane extends AbstractAirplane {
    private Wing wing;       // Крыло
    private Chassis chassis; // Шасси
    private Engine engine;   // Двигатель

    public Airplane(String model, String destination, int fuelConsumption, String dayOfWeek,
                    Wing wing, Chassis chassis, Engine engine) {
        super(model, destination, fuelConsumption, dayOfWeek);
        this.wing = wing;
        this.chassis = chassis;
        this.engine = engine;
    }

    public Wing getWing() {
        return wing;
    }

    public Chassis getChassis() {
        return chassis;
    }

    public Engine getEngine() {
        return engine;
    }

    @Override
    public String toString() {
        return super.toString() + ", Компоненты: [" + wing + ", " + chassis + ", " + engine + "]";
    }
}
