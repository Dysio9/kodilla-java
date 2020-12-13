package com.kodilla.good.patterns.food2door;

import java.util.Map;
import java.util.Objects;

public class Order {
    private User user;
    private Map<Product, Integer> orderedProducts;

    public Order(User user, Map<Product, Integer> orderedProducts) {
        this.user = user;
        this.orderedProducts = orderedProducts;
    }

    public Map<Product, Integer> getOrderedProducts() {
        return orderedProducts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(orderedProducts, order.orderedProducts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, orderedProducts);
    }
}
