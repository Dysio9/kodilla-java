package com.kodilla.good.patterns.food2door;

import java.util.List;

public class OrderProcessor {
    private final Order order;
    private Shop shop;
    private List<Shop> shops;


    public OrderProcessor(Shop shop, Order order) {
        this.shop = shop;
        this.order = order;
    }

    public void realizeOrder() {
        boolean status = shop.process(order);

        System.out.println(status ? "\nOrder has been realized" : "\nOrder has not been realized");
    }
}
