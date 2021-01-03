package com.kodilla.patterns.factory.tasks;

public final class ShoppingTask implements Task {
    private final String name;
    private final String whatToBuy;
    private final double quantity;
    private boolean executed = false;

    public ShoppingTask(final String name, final String whatToBuy, final double quantity) {
        this.name = name;
        this.whatToBuy = whatToBuy;
        this.quantity = quantity;
    }

    @Override
    public void executeTask() {
        executed = true;
    }

    @Override
    public String getTaskName() {
        return name;
    }

    @Override
    public boolean isTaskExecuted() {
        return executed;
    }
}
