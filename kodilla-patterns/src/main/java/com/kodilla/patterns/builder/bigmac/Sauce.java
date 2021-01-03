package com.kodilla.patterns.builder.bigmac;

public enum Sauce {
    STANDARD("Standard"),
    THOUSAND_ISLANDS("1000 Islands"),
    BARBECUE("Barbecue"),
    MIXED("Mixed sauce");

    private String sauce;

    Sauce(String sauce) {
        this.sauce = sauce;
    }

    @Override
    public String toString() {
        return sauce;
    }

    public static boolean contains(String test) {
        for (Ingredients ingredient : Ingredients.values()) {
            if (ingredient.name().equals(test)) {
                return true;
            }
        }
        return false;
    }
}
