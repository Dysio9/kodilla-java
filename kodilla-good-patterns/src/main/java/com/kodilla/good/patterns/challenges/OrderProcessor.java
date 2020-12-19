package com.kodilla.good.patterns.challenges;

public class OrderProcessor {

//    private final InformationService informationService;
//    private final OrderService orderService;
//    private final OrderRepository orderRepository;

//    public OrderProcessor(InformationService informationService, OrderService orderService, OrderRepository orderRepository) {
//        this.informationService = informationService;
//        this.orderService = orderService;
//        this.orderRepository = orderRepository;
//    }
//
//    public OrderDto process(final OrderRequest orderRequest) {
//        boolean isOrdered = orderService.order(orderRequest);
//        if (isOrdered) {
//            informationService.inform(orderRequest);
//            orderRepository.createOrder(orderRequest);
//            return new OrderDto(orderRequest.getUser(), true);
//        } else {
//            return new OrderDto(orderRequest.getUser(), false);
//        }
//    }
}
