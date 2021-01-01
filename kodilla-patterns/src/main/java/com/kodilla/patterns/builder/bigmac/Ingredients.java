package com.kodilla.patterns.builder.bigmac;

public enum Ingredients {
    SALAD("Salad"),
    ONION("Onion"),
    BEACON("Beacon"),
    CUCUMBER("Cucumber"),
    CHILLIS("Chilli peppers"),
    MUSHROOMS("Mushrooms"),
    PRAWNS("Prawns"),
    CHEESE("Cheese"),
    POTATOES("Potatoes");

    private String ingredient;

    Ingredients(String ingredient) {
        this.ingredient = ingredient;
    }

    @Override
    public String toString() {
        return ingredient;
    }
}
