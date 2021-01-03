package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public class Bigmac {
    private final Bun bun;
    private final int burgers;
    private final Sauce sauce;
    private final List<Ingredients> ingredients = new ArrayList<>();

    private Bigmac(final Bun bun, final int burgers, final Sauce sauce, final List<Ingredients> ingredients) {
        this.bun = bun;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients.addAll(ingredients);
    }

    @Override
    public String toString() {
        return "Your Bigmac{" +
                "bun='" + bun + '\'' +
                ", burgers=" + burgers +
                ", sauce='" + sauce + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }

    public Bun getBun() {
        return bun;
    }

    public int getBurgers() {
        return burgers;
    }

    public Sauce getSauce() {
        return sauce;
    }

    public List<Ingredients> getIngredients() {
        return ingredients;
    }

    public static class BigmacBuilder {
        private static final int MIN_BURGERS = 1;
        private static final int MAX_BURGERS = 3;
        private Bun bun = Bun.WHITE;
        private int burgers = 1;
        private Sauce sauce = Sauce.STANDARD;
        private List<Ingredients> ingredients = new ArrayList<>();

        public BigmacBuilder bun(Bun bun) {
            this.bun = bun;
            return this;
        }

        public BigmacBuilder burgers(int burgers) {
            if (burgers >= MIN_BURGERS && burgers <= MAX_BURGERS) {
                this.burgers = burgers;
            } else {
                throw new IllegalArgumentException("Wrong number of burgers. The allowed number of burgers:"
                        + MIN_BURGERS + " - " + MAX_BURGERS);
            }
            return this;
        }

        public BigmacBuilder sauce(Sauce sauce) {
            this.sauce = sauce;
            return this;
        }

        public BigmacBuilder extraIngredient(Ingredients ingredient) {
                this.ingredients.add(ingredient);
            return this;
        }

        public Bigmac cook() {
            return new Bigmac(bun, burgers, sauce, ingredients);
        }
    }
}
