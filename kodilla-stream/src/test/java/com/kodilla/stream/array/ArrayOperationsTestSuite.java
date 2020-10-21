package com.kodilla.stream.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayOperationsTestSuite {

    @Test
    public void testGetAverage() {
        //Given
        int[] numbers = new int[] {11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};

        //When
        double result = ArrayOperations.getAverage(numbers);

        //Then
        Assertions.assertEquals(20.5, result);
    }
}
