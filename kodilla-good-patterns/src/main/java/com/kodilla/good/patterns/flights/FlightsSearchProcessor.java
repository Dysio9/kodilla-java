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
                System.out.println(searchAllFlightsFrom(searchedAirport));
            } else {
                System.out.println(searchAllFlightsTo(searchedAirport));
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

    private Flights searchAllFlightsFrom(String departureAirport) {
        List<Flight> flightsTmp = flights.getAllFlights().stream()
                .filter(flight -> flight.getDepartureAirport().equals(departureAirport))
                .collect(Collectors.toList());
        return new Flights(flightsTmp);
    }

    private Flights searchAllFlightsTo(String arrivalAirport) {
        List<Flight> flightsTmp = flights.getAllFlights().stream()
                .filter(flight -> flight.getArrivalAirport().equals(arrivalAirport))
                .collect(Collectors.toList());
        return new Flights(flightsTmp);
    }

    private Flights searchDirectFlightFromTo (String departureAirport, String arrivalAirport) {
        List<Flight> flightsTmp = flights.getAllFlights().stream()
                .filter(flight -> flight.getDepartureAirport().equals(departureAirport))
                .filter(flight -> flight.getArrivalAirport().equals(arrivalAirport))
                .collect(Collectors.toList());
        return new Flights(flightsTmp);
    }

    private List<Flights> searchConnectingFlight (String departureAirport, String arrivalAirport) {
        List<Flights> foundFlights = new ArrayList<>();
        List<Flight> flightsFirst = searchAllFlightsFrom(departureAirport).getAllFlights();

        for (Flight flight : flightsFirst) {
            List<Flight>  flightsSecond = flights.getAllFlights().stream()
                    .filter(fl -> fl.getDepartureAirport().equals(flight.getArrivalAirport()))
                    .filter(fl -> fl.getArrivalAirport().equals(arrivalAirport))
                    .collect(Collectors.toList());

            if (flightsSecond.size() != 0) {
                for (Flight f : flightsSecond) {
                    if (flight.getArrivalTime().isBefore(f.getDepartureTime())) {
                        List<Flight> flightsConnecting = new ArrayList<>();
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
