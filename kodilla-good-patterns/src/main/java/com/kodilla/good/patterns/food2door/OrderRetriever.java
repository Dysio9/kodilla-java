package com.kodilla.good.patterns.food2door;

import java.util.HashMap;
import java.util.Map;

public class OrderRetriever {

    public Order retriever1() {
        Map<Product, Integer> products = new HashMap<>();
        products.put(new Product("Cheese","sliced",0.3), 3);
        products.put(new Product("Sausages","BigPack",0.5), 5);

        User user = new User("Franek","Surrealistyczny","ul. Opoki 25, 45-345 Leszno");
        System.out.println("My order: " + products);
        return new Order(user,products);
    }

    public Order retriever2() {
        Map<Product, Integer> products = new HashMap<>();
        products.put(new Product("White Cheese","fat",0.2), 2);

        User user = new User("Anastasia","Kowalska", "ul. Zwykła 15/14, 01-200 Warszawa");
        System.out.println("My order: " + products);
        return new Order(user,products);
    }

    public Order retriever3() {
        Map<Product, Integer> products = new HashMap<>();
        products.put(new Product("Nuggets","deep frozen",0.5), 3);
        products.put(new Product("Cheese Dip","highly processed",0.3), 1);

        User user = new User("Borys","Zawacki", "ul. Kolędy 2, 20-454 Zawiercie");
        System.out.println("My order: " + products);
        return new Order(user,products);
    }
}
