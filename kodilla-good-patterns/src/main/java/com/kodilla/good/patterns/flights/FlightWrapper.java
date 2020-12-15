package com.kodilla.good.patterns.flights;

import java.util.List;

public final class FlightWrapper {
    private final List<Flight> flights;

    public FlightWrapper(final List<Flight> flights) {
        this.flights = flights;
    }

    public List<Flight> getAllFlights() {
        return flights;
    }

    @Override
    public String toString() {
        return "Found " + flights.size() + " flight(s):\n" + flights;
    }
}