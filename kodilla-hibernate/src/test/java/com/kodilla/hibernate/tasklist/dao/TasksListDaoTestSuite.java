package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TasksList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class TasksListDaoTestSuite {

    static final String LISTNAME = "Example of list name";
    static final String DESCRIPTION = "Example of TaskList name";

    @Autowired
    TasksListDao taskListDao;

    @Test
    void testFindByListName() {
        //Given
        TasksList tasksList = new TasksList(LISTNAME, DESCRIPTION);

        //When
        taskListDao.save(tasksList);

        //Then
        int id = tasksList.getId();
        List<TasksList> readTasksList = taskListDao.findByListName(LISTNAME);
        assertTrue(readTasksList.contains(tasksList));

        //CleanUp
        taskListDao.deleteById(id);
    }
}
