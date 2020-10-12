package com.kodilla.testing.collection;

import org.junit.Test;
import org.junit.jupiter.api.*;
import java.util.Arrays;
import java.util.List;

public class CollectionTestSuite {
    //Given
    OddNumberExterminator oddNumberExterminator = new OddNumberExterminator();

    @DisplayName(
            "Verification if the function OddNumberExterminator works properly with the empty entry list"
    )
    @Test
    public void testOddNumberExterminatorEmptyList() {
        //When
        List<Integer> actual = oddNumberExterminator.numbers(Arrays.asList());
        List<Integer> expected = Arrays.asList();

        //Then
        Assertions.assertIterableEquals(expected, actual);
    }

    @DisplayName(
            "Verification if the function OddNumberExterminator works properly with the normal entry list"
    )
    @Test
    public void testOddNumberExterminatorNormalList() {
        //When
        List<Integer> actual = oddNumberExterminator.numbers(Arrays.asList(1,2,3,4,5,6,7,8,9,0,10,11,12,13));
        List<Integer> expected = Arrays.asList(2,4,6,8,0,10,12);

        //Then
        Assertions.assertIterableEquals(expected, actual);
    }
}