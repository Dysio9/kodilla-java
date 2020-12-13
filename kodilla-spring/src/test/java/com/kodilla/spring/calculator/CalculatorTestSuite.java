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
    public void testCalculations() {
        //Given
        //When
        double sumResult = calculator.add(6,3);
        double subResult = calculator.sub(6,3);
        double mulResult = calculator.mul(6,3);
        double divResult = calculator.div(6,3);

        //Then
        assertEquals(9, sumResult);
        assertEquals(3, subResult);
        assertEquals(18, mulResult);
        assertEquals(2, divResult);
    }
}
