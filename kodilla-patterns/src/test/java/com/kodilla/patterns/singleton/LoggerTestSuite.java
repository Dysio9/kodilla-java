package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class LoggerTestSuite {
    private static Logger logger;

    @BeforeAll
    public static void openLog() {
        logger = Logger.INSTANCE;
    }

    @Test
    public void testGetLastLog() {
        //Given
        logger.log("First log");

        //When
        String result = logger.getLastLog();

        //Then
        Assertions.assertEquals("First log", result);
    }

    @Test
    public void testLog() {
        //Given
        logger.log("Log no 1.");

        //When
        logger.log("Log no 2.");
        String result = logger.getLastLog();

        //Then
        Assertions.assertEquals("Log no 2.", result);
    }
}
