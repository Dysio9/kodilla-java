package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FlightSearchEngine {
    public void findFlight(Flight flight) throws RouteNotFoundException {
        Map<String, Boolean> airports = new HashMap<>();
        airports.put("Lublin",true);
        airports.put("Warszawa", true);
        airports.put("Londyn", true);
        airports.put("Berlin", true);
        airports.put("Praga", false);
        airports.put("Roterdam", false);
        airports.put("Władywostok", true);
        airports.put("Paryż", false);

        // Dla treningu (na dwa sposoby) streamowałem listę lotnisk i przez wyjątek przekazałem ją do programu
        String allOpenedAirports = airports.entrySet().stream()
                .filter(Map.Entry::getValue)
                .map(Map.Entry::getKey)
                .reduce("", (x,y) -> x.concat(y) + ", ");

        String allAirports = airports.keySet().stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));

        System.out.println(allAirports);

        if (!airports.containsKey(flight.getDepartureAirport())) {
            throw new RouteNotFoundException(allOpenedAirports, allAirports);
        }

        if (airports.containsKey(flight.getDepartureAirport())) {
            if (airports.get(flight.getDepartureAirport())) {
                System.out.println("Departure airport in " + flight.getDepartureAirport() + " is opened");
            } else {
                System.out.println("Sorry! Departure airport in " + flight.getDepartureAirport() + " is closed");
            }
        }

        if (!airports.containsKey(flight.getArrivalAirport())) {
            throw new RouteNotFoundException(allOpenedAirports, allAirports);
        }

        if (airports.containsKey(flight.getArrivalAirport())) {
            if (airports.get(flight.getArrivalAirport())) {
                System.out.println("Arrival airport in " + flight.getArrivalAirport() + " is opened");
            } else {
                System.out.println("Sorry! Arrival airport in " + flight.getArrivalAirport() + " is closed");
            }
        }

        if (airports.get(flight.getArrivalAirport()) && airports.get(flight.getDepartureAirport())) {
            System.out.println("Congratulations! Your flight connection has been found!");
        }
    }


    public static void main(String[] args) {
        String departureAirport;
        String arrivalAirport;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Flight Search Engine");
        System.out.print("Type departure airport: ");
        departureAirport = scanner.nextLine();
        System.out.print("Type destination airport: ");
        arrivalAirport = scanner.nextLine();
        System.out.println("\nSearching flight from \"" + departureAirport + "\" to \"" + arrivalAirport + "\".");

        FlightSearchEngine flightSearchEngine = new FlightSearchEngine();

        try {
            flightSearchEngine.findFlight(new Flight(departureAirport, arrivalAirport));
        } catch (RouteNotFoundException e) {
            System.out.println("Error: " + e + ". There is no such airport. " +
                    "Check name spelling or try the other airport. " +
                    "\nThe list of all airports: " + e.getAllAirports() +
                    "\nYou can use only opened airports: " + e.getOpenedAirports());
        }
    }
}
