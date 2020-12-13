package com.kodilla.good.patterns.flights;

import java.util.List;
import java.util.Set;

public final class Flights {
    private final List<Flight> flights;


    public Flights(final List<Flight> flights) {
        this.flights = flights;
    }

    public boolean addFlight(Flight flight) {
        flights.add(flight);
        return true;
    }

    public boolean addAllFlights(List<Flight> sendFlights) {
        flights.addAll(sendFlights);
        return true;
    }

    public List<Flight> getAllFlights() {
        return flights;
    }

    @Override
    public String toString() {
        return "Found " + flights.size() + " flight(s):\n" + flights;
    }
}