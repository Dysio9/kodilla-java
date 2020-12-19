package com.kodilla.spring.portfolio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BoardConfig {

    @Bean(name = "toDoTaskList")
    public TaskList getTasksToDo() {
        return new TaskList();
    }

    @Bean(name = "inProgressTaskList")
    public TaskList getTasksInProgress() {
        return new TaskList();
    }

    @Bean(name = "doneTaskList")
    public TaskList getTasksDone() {
        return new TaskList();
    }

    @Bean
    public Board getBoard() {
        return new Board(getTasksToDo(), getTasksInProgress(),getTasksDone());
    }
}
