package com.kodilla.good.patterns.food2door;

import java.util.ArrayList;
import java.util.List;

public class ShopRetriever {

    public List<Shop> retrieve() {
        List<Shop> shops = new ArrayList<>();
        shops.add(retrieve1());
        shops.add(retrieve2());
        shops.add(retrieve3());
        return shops;
    }

    public Shop retrieve1() {
        List<Product> offeredProducts = new ArrayList<>();
        offeredProducts.add(new Product("Milk","2% fat",1));
        offeredProducts.add(new Product("Cheese","sliced",0.3));
        offeredProducts.add(new Product("Sausages","BigPack",0.5));
        offeredProducts.add(new Product("Ketchup","mild",0.5));
        offeredProducts.add(new Product("Cacao", "no preservatives",1));
        return new GlutenFreeShop(new OfferedProducts(offeredProducts));
    }

    public Shop retrieve2() {
        List<Product> offeredProducts = new ArrayList<>();
        offeredProducts.add(new Product("Natural yogurt","2% fat",0.2));
        offeredProducts.add(new Product("White Cheese","semi-fat",0.2));
        offeredProducts.add(new Product("White Cheese","fat",0.2));
        offeredProducts.add(new Product("White Cheese","lean",0.2));
        return new HealthyShop(new OfferedProducts(offeredProducts));
    }

    public Shop retrieve3() {
        List<Product> offeredProducts = new ArrayList<>();
        offeredProducts.add(new Product("Chips","deep frozen",1));
        offeredProducts.add(new Product("Nuggets","deep frozen",0.5));
        offeredProducts.add(new Product("Cheese Dip","highly processed",0.3));
        offeredProducts.add(new Product("Popcorn","Salty",0.5));
        offeredProducts.add(new Product("Sausages","BigPack",0.5));
        offeredProducts.add(new Product("Ketchup","mild",0.5));
        offeredProducts.add(new Product("Cacao", "no preservatives",1));
        return new ExtraFoodShop(new OfferedProducts(offeredProducts));
    }
}
