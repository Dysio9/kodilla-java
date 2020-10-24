package com.kodilla.stream.array;

import java.util.Arrays;

public interface ArrayOperations {
    static double getAverage(int[] numbers) {
        Arrays.stream(numbers).forEach(number -> System.out.print(number + " "));

        return Arrays.stream(numbers).average().getAsDouble();
    }
}
