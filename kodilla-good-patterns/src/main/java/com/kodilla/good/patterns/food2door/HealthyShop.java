package com.kodilla.good.patterns.food2door;

import java.util.List;

public class HealthyShop implements Shop {
    private OfferedProducts offeredProducts;

    public HealthyShop(OfferedProducts offeredProducts) {
        this.offeredProducts = offeredProducts;
    }

    @Override
    public List<Product> getProducts() {
        return offeredProducts.getOfferedProducts();
    }

    @Override
    public boolean process(Order order) {
        if (offeredProducts.getOfferedProducts().containsAll(order.getOrderedProducts().keySet())) {
            System.out.println("             -> --> ---> Welcome in Healthy Shop <--- <-- <-");
            System.out.println("Thank You for trust! Healthy Shop is going to send your order as soon as possible");
            return true;
        } else {
            System.out.println("-> --> ---> Welcome in Healthy Shop <--- <-- <-");
            System.out.println("We're not able to realize your order. Sorry.");
            return false;
        }
    }

    @Override
    public String toString() {
        return "HealthyShop";
    }
}
