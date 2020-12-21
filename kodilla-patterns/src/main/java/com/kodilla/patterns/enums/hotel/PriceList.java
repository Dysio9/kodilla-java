package com.kodilla.patterns.enums.hotel;

import java.math.BigDecimal;
import java.util.Map;

public class PriceList {

    private static Map<String, BigDecimal> singleBedPrices = Map.of(
            "LOW", new BigDecimal(250),
            "HIGH", new BigDecimal(320),
            "HOLIDAY", new BigDecimal(400)
    );

    private static Map<String, BigDecimal> doubleBedPrices = Map.of(
            "LOW", new BigDecimal(350),
            "HIGH", new BigDecimal(400),
            "HOLIDAY", new BigDecimal(500)
    );

    public static BigDecimal getSingleBedPrice(String season) {
        return singleBedPrices.get(season);
    }

    public static BigDecimal getDoubleBedPrice(String season) {
        return doubleBedPrices.get(season);
    }
}