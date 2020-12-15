package com.kodilla.spring.portfolio;

public class Board {
    private TaskList doDoList;
    private TaskList inProgressList;
    private TaskList doneList;

    public Board(TaskList doDoList, TaskList inProgressList, TaskList doneList) {
        this.doDoList = doDoList;
        this.inProgressList = inProgressList;
        this.doneList = doneList;
    }

    public String showBoard() {
        System.out.println("================== Board ==================");
        System.out.println("       >>> Tasks to do <<< \n" + doDoList.getTasks());
        System.out.println("    >>> Tasks in Progress <<< \n" + inProgressList.getTasks());
        System.out.println("    >>> Already done tasks <<< \n" + doneList.getTasks());
        System.out.println("===========================================");

        return doDoList.getTasks() + " - " + inProgressList.getTasks() + " - " + doneList.getTasks();
    }
}
