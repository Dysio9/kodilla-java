package com.kodilla.spring.portfolio;

public class Board {
    TaskList doDoList;
    TaskList inProgressList;
    TaskList doneList;

    public Board(TaskList doDoList, TaskList inProgressList, TaskList doneList) {
        this.doDoList = doDoList;
        this.inProgressList = inProgressList;
        this.doneList = doneList;
    }

    public void showBoard() {
        System.out.println("================== Board ==================");
        System.out.println("       >>> Tasks to do <<< \n" + doDoList.getTasks());
        System.out.println("    >>> Tasks in Progress <<< \n" + inProgressList.getTasks());
        System.out.println("    >>> Already done tasks <<< \n" + doneList.getTasks());
        System.out.println("===========================================");
    }
}
