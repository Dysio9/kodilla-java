package com.kodilla.good.patterns.flights;

import java.time.LocalDateTime;
import java.util.Arrays;

public class FlightsRetriever {

    public static FlightWrapper retrieve() {
        Flight flight1 = new Flight(
                "Lublin",
                "Warszawa",
                LocalDateTime.of(2020, 12, 1, 9, 20),
                LocalDateTime.of(2020, 12, 1, 10, 20));
        Flight flight2 = new Flight(
                "Lublin",
                "Warszawa",
                LocalDateTime.of(2020, 12, 3, 9, 20),
                LocalDateTime.of(2020, 12, 3, 10, 20));
        Flight flight3 = new Flight(
                "Lublin",
                "Warszawa",
                LocalDateTime.of(2020, 12, 5, 9, 20),
                LocalDateTime.of(2020, 12, 5, 10, 20));
        Flight flight4 = new Flight(
                "Lublin",
                "Warszawa",
                LocalDateTime.of(2020, 12, 7, 9, 20),
                LocalDateTime.of(2020, 12, 7, 10, 20));
        Flight flight5 = new Flight(
                "Lublin",
                "Wrocław",
                LocalDateTime.of(2020, 12, 9, 9, 20),
                LocalDateTime.of(2020, 12, 9, 10, 20));
        Flight flight6 = new Flight(
                "Warszawa",
                "Kraków",
                LocalDateTime.of(2020, 12, 1, 12, 30),
                LocalDateTime.of(2020, 12, 1, 13, 20));
        Flight flight7 = new Flight(
                "Lublin",
                "Gdańsk",
                LocalDateTime.of(2020, 12, 9, 14, 50),
                LocalDateTime.of(2020, 12, 9, 16, 0));
        Flight flight8 = new Flight(
                "Warszawa",
                "Gdańsk",
                LocalDateTime.of(2020, 12, 9, 15, 20),
                LocalDateTime.of(2020, 12, 9, 12, 20));
        Flight flight9 = new Flight(
                "Wrocław",
                "Gdańsk",
                LocalDateTime.of(2020, 12, 9, 18, 20),
                LocalDateTime.of(2020, 12, 9, 19, 15));
        Flight flight10 = new Flight(
                "Wrocław",
                "Warszawa",
                LocalDateTime.of(2020, 12, 9, 22, 35),
                LocalDateTime.of(2020, 12, 9, 23, 45));
        Flight flight11 = new Flight(
                "Wrocław",
                "Lublin",
                LocalDateTime.of(2020, 12, 10, 8, 35),
                LocalDateTime.of(2020, 12, 10, 9, 45));
        Flight flight12 = new Flight(
                "Gdańsk",
                "Lublin",
                LocalDateTime.of(2020, 12, 9, 15, 50),
                LocalDateTime.of(2020, 12, 9, 17, 30));
        Flight flight13 = new Flight(
                "Gdańsk",
                "Warszawa",
                LocalDateTime.of(2020, 12, 1, 14, 50),
                LocalDateTime.of(2020, 12, 1, 15, 10));
        Flight flight14 = new Flight(
                "Warszawa",
                "Lublin",
                LocalDateTime.of(2020, 12, 2, 13, 50),
                LocalDateTime.of(2020, 12, 2, 14, 10));
        Flight flight15 = new Flight(
                "Warszawa",
                "Lublin",
                LocalDateTime.of(2020, 12, 3, 18, 30),
                LocalDateTime.of(2020, 12, 3, 19, 2));

        return new FlightWrapper(Arrays.asList(flight1, flight2, flight3, flight4, flight5, flight6, flight7, flight8,
                flight9, flight10, flight11, flight12, flight13, flight14, flight15));
    }
}
