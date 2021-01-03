package com.kodilla.patterns.factory.tasks;

public final class PaintingTask implements Task {
    private final String name;
    private final String color;
    private final String whatToPaint;
    private boolean executed = false;

    public PaintingTask(final String name, final String color, final String whatToPaint) {
        this.name = name;
        this.color = color;
        this.whatToPaint = whatToPaint;
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
