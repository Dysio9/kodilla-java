package com.kodilla.patterns.strategy.social;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTestSuite {

    @Test
    void testDefaultSharingStrategyForMillenials() {
        //Given
        User user = new Millenials("Millennium Paul");

        //When
        String result = user.sharePost();

        //Then
        assertEquals("FB message", result);
    }

    @Test
    void testDefaultSharingStrategyForYGeneration() {
        //Given
        User user = new YGeneration("YGeneration Steve");

        //When
        String result = user.sharePost();

        //Then
        assertEquals("Twitter message", result);
    }

    @Test
    void testDefaultSharingStrategyForZGeneration() {
        //Given
        User user = new ZGeneration("YGeneration Steve");

        //When
        String result = user.sharePost();

        //Then
        assertEquals("Snapchat message", result);
    }

    @Test
    void testIndividualSharingStrategy() {
        //Given
        User user = new Millenials("Individual Millennium - Paul");

        //When
        user.setSocialMediaType(new SnapchatPublisher());
        String result = user.sharePost();

        //Then
        assertEquals("Snapchat message", result);
    }
}
