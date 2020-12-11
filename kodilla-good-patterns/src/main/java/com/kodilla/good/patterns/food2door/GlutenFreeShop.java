package com.kodilla.good.patterns.food2door;

public class GlutenFreeShop implements Shop {
    private OfferedProducts offeredProducts;

    public GlutenFreeShop(OfferedProducts offeredProducts) {
        this.offeredProducts = offeredProducts;
    }

    @Override
    public boolean process(Order order) {
        if (offeredProducts.getOfferedProducts().containsAll(order.getOrderedProducts().keySet())) {
            System.out.println("      > > >   Witaj w sklepie Gluten Free Shop!   < < <");
            System.out.println("Twoje zamówienie zostało przyjęte i przekazane do realizacji.");
            System.out.println("===================  End of the message  ====================");
            return true;
        } else {
            System.out.println("      > > >   Witaj w sklepie Gluten Free Shop!   < < <");
            System.out.println("Przykro nam. Twoje zamówienie  nie może zostać zrealizowane.");
            System.out.println("===================  End of the message  ===================");
            return false;
        }
    }
}
