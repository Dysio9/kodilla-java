package com.kodilla.good.patterns.food2door;

import java.util.HashMap;
import java.util.Map;

public class OrderRetriever {

    public Order retriever1() {
        Map<Product, Integer> products = new HashMap<>();
        products.put(new Product("Masło","98% tłuszczu.",0.2), 3);
        products.put(new Product("Ser żółty","plasterkowany",0.3), 5);
        products.put(new Product("Parówki","Opakowanie zbiorcze",0.5), 2);

        User user = new User("Franek","Surrealistyczny","ul. Opoki 25, 45-345 Leszno");
        return new Order(user,products);
    }

    public Order retriever2() {
        Map<Product, Integer> products = new HashMap<>();
        products.put(new Product("Ser biały","tłusty",0.2), 8);

        User user = new User("Anastasia","Kowalska", "ul. Zwykła 15/14, 01-200 Warszawa");
        return new Order(user,products);
    }

    public Order retriever3() {
        Map<Product, Integer> products = new HashMap<>();
        products.put(new Product("Frytki","Produkt mrożony",1), 2);

        User user = new User("Borys","Zawacki", "ul. Kolędy 2, 20-454 Zawiercie");
        return new Order(user,products);
    }
}
