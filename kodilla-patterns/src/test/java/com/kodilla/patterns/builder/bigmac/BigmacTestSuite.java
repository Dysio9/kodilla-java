package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BigmacTestSuite {

    @Test
    void testAdditionalIngredientsInDefaultBigmacBuilder() {
        //Given
        Bigmac bigmac = createDefaultBigmac();

        //When
        int additionalIngredientsNo = bigmac.getIngredients().size();

        //Then
        assertEquals(0, additionalIngredientsNo);
    }

    @Test
    void testBurgersInDefaultBigmacBuilder() {
        //Given
        Bigmac bigmac = createDefaultBigmac();

        //When
        int burgers = bigmac.getBurgers();

        //Then
        assertEquals(1, burgers);
    }

    @Test
    void testBunInDefaultBigmacBuilder() {
        //Given
        Bigmac bigmac = createDefaultBigmac();

        //When
        String bun = bigmac.getBun().toString();

        //Then
        assertEquals("White", bun);
    }

    @Test
    void testSauceInDefaultBigmacBuilder() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .cook();

        //When
        String sauce = bigmac.getSauce().toString();

        //Then
        assertEquals("Standard", sauce);
    }

    @Test
    void testAdditionalIngredientsInBigmacBuilder() {
        //Given
        Bigmac bigmac = createExtraBigmac();
        System.out.println(bigmac);

        //When
        int additionalIngredientsNo = bigmac.getIngredients().size();

        //Then
        assertEquals(3, additionalIngredientsNo);
    }

    @Test
    void testBurgersInBigmacBuilder() {
        //Given
        Bigmac bigmac = createExtraBigmac();

        //When
        int burgers = bigmac.getBurgers();

        //Then
        assertEquals(3, burgers);
    }

    @Test
    void testBunInBigmacBuilder() {
        //Given
        Bigmac bigmac = createExtraBigmac();

        //When
        String bun = bigmac.getBun().toString();

        //Then
        assertEquals("White with sesame", bun);
    }

    @Test
    void testSauceInBigmacBuilder() {
        //Given
        Bigmac bigmac = createExtraBigmac();

        //When
        String sauce = bigmac.getSauce().toString();

        //Then
        assertEquals("Barbecue", sauce);
    }

    public Bigmac createDefaultBigmac() {
        return new Bigmac.BigmacBuilder().cook();
    }

    public Bigmac createExtraBigmac() {
        return new Bigmac.BigmacBuilder()
                .bun(Bun.WHITE_SESAME)
                .burgers(3)
                .sauce(Sauce.BARBECUE)
                .extraIngredient(Ingredients.CHEESE)
                .extraIngredient(Ingredients.BEACON)
                .extraIngredient(Ingredients.MUSHROOMS)
                .cook();
    }
}
