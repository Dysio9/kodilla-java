package com.kodilla.exception.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class SecondChallengeTestSuit {

    @ParameterizedTest
    @CsvSource({"1.0,1.5","2.0,1.0","0.0,0.0"})
    void testProbablyIWillThrowException(double a, double b) {
        //given
        SecondChallenge secondChallenge = new SecondChallenge();
        //when & then
        Assertions.assertThrows(java.lang.Exception.class,
                () -> secondChallenge.probablyIWillThrowException(a, b));
    }

    @Test
    void testProbablyIWillThrowExceptionWithoutAnException() {
        //given
        SecondChallenge secondChallenge = new SecondChallenge();
        //when & then
        Assertions.assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1.0,2.0));
    }
}
