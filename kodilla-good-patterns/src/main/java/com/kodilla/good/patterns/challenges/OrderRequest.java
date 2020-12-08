package com.kodilla.good.patterns.challenges;

import java.util.Map;

public class OrderRequest {

    private User user;
    private Map<Product, Integer> products;

    public OrderRequest(User user, Map<Product, Integer> products) {
        this.user = user;
        this.products = products;
    }

    public User getUser() {
        return user;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }
}
