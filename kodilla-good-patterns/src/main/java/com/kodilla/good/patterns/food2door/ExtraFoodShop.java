package com.kodilla.good.patterns.food2door;

import java.util.List;

public class ExtraFoodShop implements Shop {
    private OfferedProducts offeredProducts;

    public ExtraFoodShop(OfferedProducts offeredProducts) {
        this.offeredProducts = offeredProducts;
    }

    @Override
    public List<Product> getProducts() {
        return offeredProducts.getOfferedProducts();
    }

    @Override
    public boolean process(Order order) {
        if (offeredProducts.getOfferedProducts().containsAll(order.getOrderedProducts().keySet())) {
            System.out.println();
            System.out.println("------------------------------   Extra Food Shop   ------------------------------------");
            System.out.println("                   Your order has been accepted. Will be send in 24h");
            System.out.println("---------------------------------------------------------------------------------------");
            return true;
        } else {
            System.out.println();
            System.out.println("----------------------------   Extra Food Shop   ---------------------------------");
            System.out.println("                       Your order can not be realized! ");
            System.out.println("----------------------------------------------------------------------------------");
            return false;
        }
    }

    @Override
    public String toString() {
        return "ExtraFoodShop";
    }
}
