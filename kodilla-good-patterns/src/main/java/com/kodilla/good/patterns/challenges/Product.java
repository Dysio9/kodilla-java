package com.kodilla.good.patterns.challenges;

public class Product {
    private String name;

    public Product(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
