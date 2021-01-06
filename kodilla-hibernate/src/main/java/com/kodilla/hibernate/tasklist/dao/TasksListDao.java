package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TasksList;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TasksListDao extends CrudRepository<TasksList, Integer> {

    List<TasksList> findByListName(String listName);
}
