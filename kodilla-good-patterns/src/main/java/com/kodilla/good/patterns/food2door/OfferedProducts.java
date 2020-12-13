package com.kodilla.good.patterns.food2door;

import java.util.ArrayList;
import java.util.List;

public class OfferedProducts {
    private final List<Product> offeredProducts;

    public OfferedProducts(List<Product> offeredProducts) {
        this.offeredProducts = offeredProducts;
    }

    public ArrayList<Product> getOfferedProducts() {
        return new ArrayList<>(offeredProducts);
    }
}
