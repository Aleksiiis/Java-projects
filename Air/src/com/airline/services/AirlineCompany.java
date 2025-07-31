package com.airline.services;

import com.airline.interfaces.CompanyOperations;
import com.airline.models.AbstractAirplane;

import java.util.ArrayList;
import java.util.List;

public class AirlineCompany implements CompanyOperations {
    private List<AbstractAirplane> airplanes;

    public AirlineCompany() {
        this.airplanes = new ArrayList<>();
    }

    @Override
    public void addAirplane(AbstractAirplane airplane) {
        airplanes.add(airplane);
    }

    @Override
    public void removeAirplane(String model) {
        airplanes.removeIf(a -> a.getModel().equalsIgnoreCase(model));
    }

    @Override
    public List<AbstractAirplane> findAirplanesByDestination(String destination) {
        return airplanes.stream()
                .filter(a -> a.getDestination().equalsIgnoreCase(destination))
                .toList();
    }

    @Override
    public List<AbstractAirplane> findAirplanesByDay(String dayOfWeek) {
        return airplanes.stream()
                .filter(a -> a.getDayOfWeek().equalsIgnoreCase(dayOfWeek))
                .toList();
    }

    public List<AbstractAirplane> getAirplanes() {
        return new ArrayList<>(airplanes);
    }
}
