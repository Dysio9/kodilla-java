package com.kodilla.patterns.factory.tasks;

public final class TaskFactory {
    public static final String SHOPPING = "Shopping";
    public static final String PAINTING = "Painting";
    public static final String DRIVING = "Driving";

    public final Task makeTask(final String taskClass) {
        switch (taskClass) {
            case SHOPPING:
                return new ShoppingTask("shopping task","bread",2);
            case PAINTING:
                return new PaintingTask("painting task","blue","flat");
            case DRIVING:
                return new DrivingTask("driving task","city center","taxi");
            default:
                return null;
        }
    }
}
