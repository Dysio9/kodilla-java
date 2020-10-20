package com.kodilla.stream.world;

import org.junit.jupiter.api.*;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class WorldTestSuite {

    @Test
    public void testGetPeopleQuantity() {
        //given
        World world = new World();

        //when
        BigDecimal worldPopulation = world.getPeopleQuantity();

        //then
        BigDecimal expectedWorldPopulation = new BigDecimal("832640489");
        assertEquals(expectedWorldPopulation, worldPopulation);

    }
}
