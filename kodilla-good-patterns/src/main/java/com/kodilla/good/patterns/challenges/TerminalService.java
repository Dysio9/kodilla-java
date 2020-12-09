package com.kodilla.good.patterns.challenges;

public class TerminalService implements InformationService {
    @Override
    public void inform(OrderRequest orderRequest) {
        System.out.println("User (" + orderRequest.getUser() + ") thank You for Your order.");
        System.out.println("Your list of ordered products: ");
        orderRequest.getProducts().entrySet().stream().forEach(System.out::println);
    }
}
