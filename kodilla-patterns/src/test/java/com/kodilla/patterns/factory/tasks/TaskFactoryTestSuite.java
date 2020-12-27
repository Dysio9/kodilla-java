package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskFactoryTestSuite {

    @Test
    void testTaskFactoryDrivingTask() {
        //Given
        TaskFactory factory = new TaskFactory();

        //When
        Task drivingTask = factory.makeTask(TaskFactory.DRIVING);

        //Then
        assertEquals("driving task", drivingTask.getTaskName());
    }

    @Test
    void testTaskFactoryPaintingTask() {
        //Given
        TaskFactory factory = new TaskFactory();

        //When
        Task drivingTask = factory.makeTask(TaskFactory.PAINTING);

        //Then
        assertEquals("painting task", drivingTask.getTaskName());
    }

    @Test
    void testTaskFactoryShoppingTask() {
        //Given
        TaskFactory factory = new TaskFactory();

        //When
        Task drivingTask = factory.makeTask(TaskFactory.SHOPPING);

        //Then
        assertEquals("shopping task", drivingTask.getTaskName());
    }
}
