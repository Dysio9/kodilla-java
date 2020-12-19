package com.kodilla.good.patterns.flights;

import java.time.LocalDateTime;

public final class Flight {
    private final String departureAirport;
    private final String arrivalAirport;
    private final LocalDateTime departureTime;
    private final LocalDateTime arrivalTime;

    public Flight(final String departureAirport, final String arrivalAirport,
                  final LocalDateTime departureTime, final LocalDateTime arrivalTime) {
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    @Override
    public String toString() {
        return "Flight{ " + departureAirport + " - " + arrivalAirport
                + " departure: " + departureTime
                + " arrival: " + arrivalTime + "}\n";
    }
}
