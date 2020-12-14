package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
public class BoardTestSuite {

    @Test
    public void testTaskAdd() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);

        //When
        TaskList toDoTasks = (TaskList)context.getBean("toDoTaskList");
        TaskList inProgressTasks = (TaskList)context.getBean("inProgressTaskList");
        TaskList doneTasks = (TaskList)context.getBean("doneTaskList");

        toDoTasks.addTask("Get sleep");
        inProgressTasks.addTask("Work hard");
        doneTasks.addTask("Rest");

        //Then
        Board board = context.getBean(Board.class);
        board.showBoard();
    }

}
