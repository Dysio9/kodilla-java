package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CalculatorTestSuite {

    @Autowired
    private Calculator calculator;

    @Test
    public void testCalculationsSum() {
        //Given
        //When
        double sumResult = calculator.add(6,3);

        //Then
        assertEquals(9, sumResult);
    }

    @Test
    public void testCalculationsSub() {
        //Given
        //When
        double subResult = calculator.sub(6,3);

        //Then
        assertEquals(3, subResult);
    }

    @Test
    public void testCalculationsMul() {
        //Given
        //When
        double mulResult = calculator.mul(6,3);

        //Then
        assertEquals(18, mulResult);
    }

    @Test
    public void testCalculationsDiv() {
        //Given
        //When
        double divResult = calculator.div(6,3);

        //Then
        assertEquals(2, divResult);
    }
}
