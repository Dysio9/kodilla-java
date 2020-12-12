package com.kodilla.good.patterns.food2door;

public class Application {

    public static void main(String[] args) {
        OrderRetriever orderRetriever = new OrderRetriever();
        Order firstOrder = orderRetriever.retriever1();
        Order secondOrder = orderRetriever.retriever2();
        Order thirdOrder = orderRetriever.retriever3();

        OrderProcessor orderProcessor = new OrderProcessor(thirdOrder);
        orderProcessor.realizeOrder();
    }
}
