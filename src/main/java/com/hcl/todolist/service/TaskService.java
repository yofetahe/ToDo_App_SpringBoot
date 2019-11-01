package com.hcl.todolist.service;

import com.hcl.todolist.model.Task;

public interface TaskService {

	public Task getTaskById(long id);
	public boolean addTask(Task task);
	public boolean updateTaskById(Task task);
	public void deleteTaskById(long id);
}
