package com.kodilla.good.patterns.flights;

import java.time.LocalDateTime;

public class Flight {
    private String departureAirport;
    private String arrivalAirport;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;

    public Flight(String departureAirport, String arrivalAirport, LocalDateTime departureTime, LocalDateTime arrivalTime) {
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
