package com.kodilla.patterns.factory.tasks;

public final class DrivingTask implements Task {
    private final String name;
    private final String where;
    private final String using;
    private boolean executed = false;

    public DrivingTask(final String name, final String where, final String using) {
        this.name = name;
        this.where = where;
        this.using = using;
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
