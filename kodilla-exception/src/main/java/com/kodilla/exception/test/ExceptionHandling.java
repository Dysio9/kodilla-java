package com.kodilla.exception.test;

public class ExceptionHandling {

    public String exceptionHandler(double a, double b) {
        SecondChallenge secondChallenge = new SecondChallenge();

        try {
            return secondChallenge.probablyIWillThrowException(a, b);
        } catch (Exception e) {
            return "Error!";
        } finally {
            System.out.println("No i po sprawie. arg A: " + a + ", arg B: " + b);
        }
    }
}
