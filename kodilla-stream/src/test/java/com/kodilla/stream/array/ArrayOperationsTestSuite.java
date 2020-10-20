package com.kodilla.stream.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayOperationsTestSuite {

    @Test
    public void testGetAverage() {
        //Given
        int[] numbers = new int[20];

        //When
        double result = ArrayOperations.getAverage(numbers);

        //Then
        Assertions.assertEquals(9.5, result);
    }
}
