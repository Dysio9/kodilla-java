package com.kodilla.good.patterns.flights;

import java.util.Set;

public class Flights {
    private Set<Flight> flights;


    public Flights(Set<Flight> flights) {
        this.flights = flights;
    }

    public boolean addFlight(Flight flight) {
        flights.add(flight);
        return true;
    }

    public boolean addAllFlights(Set<Flight> sendFlights) {
        flights.addAll(sendFlights);
        return true;
    }

    public Set<Flight> getAllFlights() {
        return flights;
    }

    @Override
    public String toString() {
        return "Found " + flights.size() + " flight(s):\n" + flights;
    }
}