package com.hcl.todolist.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hcl.todolist.model.Task;

@Repository
public interface TaskRepo extends CrudRepository<Task, Long> {

}
