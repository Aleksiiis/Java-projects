package com.airline.models;

import com.airline.models.components.Chassis;
import com.airline.models.components.Engine;
import com.airline.models.components.Wing;

public class RegionalJet extends Airplane {
    public RegionalJet(String model, String destination, int fuelConsumption, String dayOfWeek,
                       Wing wing, Chassis chassis, Engine engine) {
        super(model, destination, fuelConsumption, dayOfWeek, wing, chassis, engine);
    }

    @Override
    public String toString() {
        return "Региональный самолет: " + super.toString();
    }
}
