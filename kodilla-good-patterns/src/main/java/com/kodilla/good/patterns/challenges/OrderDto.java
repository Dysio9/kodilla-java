package com.kodilla.good.patterns.challenges;

public class OrderDto {
    public User user;
    public boolean isOrdered;

    public OrderDto(User user, boolean isOrdered) {
        this.user = user;
        this.isOrdered = isOrdered;
    }
}
