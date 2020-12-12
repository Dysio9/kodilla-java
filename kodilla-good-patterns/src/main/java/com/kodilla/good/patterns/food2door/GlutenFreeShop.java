package com.kodilla.good.patterns.food2door;

import java.util.List;

public class GlutenFreeShop implements Shop {
    private OfferedProducts offeredProducts;

    public GlutenFreeShop(OfferedProducts offeredProducts) {
        this.offeredProducts = offeredProducts;
    }

    @Override
    public List<Product> getProducts() {
        return offeredProducts.getOfferedProducts();
    }

    @Override
    public boolean process(Order order) {
        if (offeredProducts.getOfferedProducts().containsAll(order.getOrderedProducts().keySet())) {
            System.out.println("       > > >   Welcome in Gluten Free Shop!   < < <");
            System.out.println("Your order has been accepted and it's realized at the moment");
            System.out.println("===================  End of the message  ===================");
            return true;
        } else {
            System.out.println("      > > >   Welcome in Gluten Free Shop!   < < <");
            System.out.println("         Sorry. Your order can not be realized");
            System.out.println("===============  End of the message  ================");
            return false;
        }
    }

    @Override
    public String toString() {
        return "GlutenFreeShop";
    }
}
