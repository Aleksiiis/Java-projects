package com.airline.interfaces;

import com.airline.models.AbstractAirplane;

import java.util.List;

public interface CompanyOperations {
    void addAirplane(AbstractAirplane airplane);
    void removeAirplane(String model);
    List<AbstractAirplane> findAirplanesByDestination(String destination);
    List<AbstractAirplane> findAirplanesByDay(String dayOfWeek);
}
