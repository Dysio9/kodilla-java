package com.kodilla.good.patterns.food2door;

import java.util.List;

public class OrderProcessor {
    private final Order order;

    public OrderProcessor(Order order) {
        this.order = order;
    }

    public void realizeOrder() {
        ShopRetriever shopRetriever = new ShopRetriever();
        List<Shop> shops = shopRetriever.retrieve();

        System.out.println("Searching shop...");

        try {
            Shop foundShop = shops.stream()
                    .filter(shop -> shop.getProducts().containsAll(order.getOrderedProducts().keySet()))
                    .findFirst().get();
            System.out.println(foundShop + " will realize your order \n");
            boolean status = foundShop.process(order);
            System.out.println(status ? "\nOrder has been realized" : "\nOrder has not been realized");
        } catch (Exception e) {
            System.out.println("No shop could realize your order!");
        }
    }
}
