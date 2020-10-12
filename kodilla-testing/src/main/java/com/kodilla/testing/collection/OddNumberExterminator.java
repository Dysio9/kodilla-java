package com.kodilla.testing.collection;

import java.util.ArrayList;
import java.util.List;

public class OddNumberExterminator {
    public List<Integer> numbers(List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException();
        }

        List<Integer> resultList = new ArrayList<>();

        for (Integer number : numbers) {
            if (number % 2 == 0) {
                resultList.add(number);
            }
        }
        return resultList;
    }
}