package com.kodilla.exception.test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExceptionHandlingTestSuite {

    @ParameterizedTest
    @CsvSource({"1.0,1.5,Error!","2.0,1.0,Error!","1.0,2.0,Done!","0.9,20,Error!"})
    void testExceptionHandlingReturnStatement(double a, double b, String expected) {
        //given
        ExceptionHandling exceptionHandling = new ExceptionHandling();
        //when & then
        assertEquals(expected, exceptionHandling.exceptionHandler(a, b));
    }
}
