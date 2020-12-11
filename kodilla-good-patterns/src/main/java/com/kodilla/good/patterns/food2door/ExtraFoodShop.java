package com.kodilla.good.patterns.food2door;

public class ExtraFoodShop implements Shop {
    private OfferedProducts offeredProducts;

    public ExtraFoodShop(OfferedProducts offeredProducts) {
        this.offeredProducts = offeredProducts;
    }

    @Override
    public boolean process(Order order) {
        if (offeredProducts.getOfferedProducts().containsAll(order.getOrderedProducts().keySet())) {
            System.out.println();
            System.out.println("------------------------------   Extra Food Shop   ------------------------------------");
            System.out.println("Zamówienie zostało przyjęte. Zamówienie zostało przyjęte i zostanie wysłane w ciągu 24h");
            System.out.println("---------------------------------------------------------------------------------------");
            return true;
        } else {
            System.out.println();
            System.out.println("----------------------------   Extra Food Shop   ---------------------------------");
            System.out.println("Zamówienie nie może zostać zrealizowane, gdyż sklep nie oferuje żądanych prdukuów.");
            System.out.println("----------------------------------------------------------------------------------");
            return false;
        }
    }
}
