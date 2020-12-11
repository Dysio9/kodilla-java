package com.kodilla.good.patterns.food2door;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        OrderRetriever orderRetriever = new OrderRetriever();
        Order firstOrder = orderRetriever.retriever1();
        Order secondOrder = orderRetriever.retriever2();
        Order thirdOrder = orderRetriever.retriever3();

        ShopRetriever shopRetriever = new ShopRetriever();
        List<Shop> shops = shopRetriever.retrieve();

        OrderProcessor orderProcessor = new OrderProcessor(shops.get(1), thirdOrder);
        orderProcessor.realizeOrder();
    }
}
