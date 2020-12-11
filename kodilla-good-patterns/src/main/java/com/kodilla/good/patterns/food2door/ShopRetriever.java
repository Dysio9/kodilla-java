package com.kodilla.good.patterns.food2door;

import java.util.ArrayList;
import java.util.List;

public class ShopRetriever {
    List<Product> offeredProducts = new ArrayList<>();

    public List<Shop> retrieve() {
        List<Shop> shops = new ArrayList<>();

        offeredProducts.add(new Product("Mleko","2% tłuszczu.",1));
        offeredProducts.add(new Product("Masło","98% tłuszczu.",0.2));
        offeredProducts.add(new Product("Ser żółty","plasterkowany",0.3));
        offeredProducts.add(new Product("Parówki","Opakowanie zbiorcze",0.5));
        offeredProducts.add(new Product("Kechup","Producent Heinz. Łagodny.",0.5));
        offeredProducts.add(new Product("Kakao", "naturalne, bez konserwantów",1));
        GlutenFreeShop glutenFreeShop = new GlutenFreeShop(new OfferedProducts(offeredProducts));

        offeredProducts.add(new Product("Jogurt Naturalny","2% tłuszczu.",0.2));
        offeredProducts.add(new Product("Ser biały","półtłusty",0.2));
        offeredProducts.add(new Product("Ser biały","tłusty",0.2));
        offeredProducts.add(new Product("Ser biały","chudy",0.2));
        HealthyShop healthyShop = new HealthyShop(new OfferedProducts(offeredProducts));

        offeredProducts.clear();
        offeredProducts.add(new Product("Frytki","Produkt mrożony",1));
        offeredProducts.add(new Product("Nuggetsy","Produkt mrożony",0.5));
        offeredProducts.add(new Product("Dip serowy","wysokoprzetworzony",0.3));
        offeredProducts.add(new Product("Popcorn","Solony",0.5));
        offeredProducts.add(new Product("Parówki","Opakowanie zbiorcze",0.5));
        offeredProducts.add(new Product("Kechup","Producent Pudliszki. Łagodny.",0.5));
        offeredProducts.add(new Product("Kakao", "naturalne, bez konserwantów",1));
        ExtraFoodShop extraFoodShop = new ExtraFoodShop(new OfferedProducts(offeredProducts));

        shops.add(glutenFreeShop);
        shops.add(healthyShop);
        shops.add(extraFoodShop);

        return shops;
    }
}
