package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class TaskListDaoTestSuite {

    static final String LISTNAME = "Example of list name";
    static final String DESCRIPTION = "Example of TaskList name";

    @Autowired
    TaskListDao taskListDao;

    @Test
    void testFindByListName() {
        //Given
        TaskList taskList = new TaskList(LISTNAME, DESCRIPTION);

        //When
        taskListDao.save(taskList);

        //Then
        int id = taskList.getId();
        List<TaskList> readTaskList = taskListDao.findByListName(LISTNAME);
        assertTrue(readTaskList.contains(taskList));

        //CleanUp
        taskListDao.deleteById(id);
    }
}
