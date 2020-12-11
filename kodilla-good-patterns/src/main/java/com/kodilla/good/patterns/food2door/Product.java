package com.kodilla.good.patterns.food2door;

import java.util.Objects;

public class Product {
    private String name;
    private String description;
    private double weight;

    public Product(String name, String description, double weight) {
        this.name = name;
        this.description = description;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.weight, weight) == 0 &&
                name.equals(product.name) &&
                Objects.equals(description, product.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description);
    }
}
