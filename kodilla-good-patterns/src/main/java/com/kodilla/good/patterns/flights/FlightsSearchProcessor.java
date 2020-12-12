package com.kodilla.good.patterns.flights;

import java.util.*;
import java.util.stream.Collectors;

public class FlightsSearchProcessor implements TravelSearchService {
    Flights flights;

    public FlightsSearchProcessor() {
        FlightsRetriever flightsRetriever = new FlightsRetriever();
        this.flights = flightsRetriever.retrieve();
    }

    @Override
    public void searchFlight() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("To find direct flight please type [d] to find connecting flight type [c].");
        System.out.println("To see all flights from or fo specific airport type [from] or [to].");
        String directFromTo = scanner.nextLine();

        if (directFromTo.equals("from") || directFromTo.equals("to")) {
            System.out.print("Type name of the airport: ");
            String searchedAirport = scanner.nextLine();
            if (directFromTo.equals("from")) {
                System.out.println(searchDirectFlightFrom(searchedAirport));
            } else {
                System.out.println(searchDirectFlightTo(searchedAirport));
            }
        } else if (directFromTo.equals("d") || directFromTo.equals("c")) {
            System.out.print("Type name of departure airport: ");
            String depAirport = scanner.nextLine();
            System.out.print("Type name of arrival airport: ");
            String arrAirport = scanner.nextLine();
            if (directFromTo.equals("d")) {
                System.out.println(searchDirectFlightFromTo(depAirport, arrAirport));
            } else {
                System.out.println(searchConnectingFlight(depAirport,arrAirport));
            }
        } else {
            System.out.println("Error! Bad searching type has been chosen!");
        }
    }

    private Flights searchDirectFlightFrom (String departureAirport) {
        Set<Flight> flightsTmp = flights.getAllFlights().stream()
                .filter(flight -> flight.getDepartureAirport().equals(departureAirport))
                .collect(Collectors.toSet());
        return new Flights(flightsTmp);
    }

    private Flights searchDirectFlightTo (String arrivalAirport) {
        Set<Flight> flightsTmp = flights.getAllFlights().stream()
                .filter(flight -> flight.getArrivalAirport().equals(arrivalAirport))
                .collect(Collectors.toSet());
        return new Flights(flightsTmp);
    }

    private Flights searchDirectFlightFromTo (String departureAirport, String arrivalAirport) {
        Set<Flight> flightsTmp = flights.getAllFlights().stream()
                .filter(flight -> flight.getDepartureAirport().equals(departureAirport))
                .filter(flight -> flight.getArrivalAirport().equals(arrivalAirport))
                .collect(Collectors.toSet());
        return new Flights(flightsTmp);
    }

    private List<Flights> searchConnectingFlight (String departureAirport, String arrivalAirport) {
        List<Flights> foundFlights = new ArrayList<>();

        Set<Flight> flightsFirst = flights.getAllFlights().stream()
                .filter(flight -> flight.getDepartureAirport().equals(departureAirport))
                .collect(Collectors.toSet());

        for (Flight flight : flightsFirst) {
            Set<Flight>  flightsSecond = flights.getAllFlights().stream()
                    .filter(fl -> fl.getDepartureAirport().equals(flight.getArrivalAirport()))
                    .filter(fl -> fl.getArrivalAirport().equals(arrivalAirport))
                    .collect(Collectors.toSet());

            if (flightsSecond.size() != 0) {
                for (Flight f : flightsSecond) {
                    if (flight.getArrivalTime().isBefore(f.getDepartureTime())) {
                        Set<Flight> flightsConnecting = new HashSet<>();
                        flightsConnecting.add(flight);
                        flightsConnecting.add(f);
                        foundFlights.add(new Flights(flightsConnecting));
                    }
                }
            }
        }
        return foundFlights;
    }
}
