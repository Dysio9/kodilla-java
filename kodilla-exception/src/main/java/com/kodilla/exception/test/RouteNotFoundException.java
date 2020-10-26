package com.kodilla.exception.test;

public class RouteNotFoundException extends Exception {
    String openedAirports;
    String allAirports;


    public RouteNotFoundException(String openedAirports) {
        this.openedAirports = openedAirports;
    }

    public RouteNotFoundException(String openedAirports, String allAirports) {
        this.openedAirports = openedAirports;
        this.allAirports = allAirports;
    }

    public String getOpenedAirports() {
        return openedAirports;
    }

    public String getAllAirports() {
        return allAirports;
    }
}
