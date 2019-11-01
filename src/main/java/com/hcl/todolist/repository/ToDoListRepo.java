package com.hcl.todolist.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hcl.todolist.model.ToDoList;

@Repository
public interface ToDoListRepo extends CrudRepository<ToDoList, Long> {

}
