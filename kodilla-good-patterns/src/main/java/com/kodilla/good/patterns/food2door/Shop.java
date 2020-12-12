package com.kodilla.good.patterns.food2door;

import java.util.List;

public interface Shop {
    boolean process(Order order);

    List<Product> getProducts();
}
