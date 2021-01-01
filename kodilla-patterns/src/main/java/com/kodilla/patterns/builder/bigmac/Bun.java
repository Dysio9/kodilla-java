package com.kodilla.patterns.builder.bigmac;

public enum Bun {
    WHITE("White"),
    WHOLE_GRAIN("Whole grain"),
    WHITE_SESAME("White with sesame"),
    WHOLE_G_SESAME("Whole grain with sesame");

    private String bun;

    Bun(String bun) {
        this.bun = bun;
    }

    @Override
    public String toString() {
        return bun;
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
