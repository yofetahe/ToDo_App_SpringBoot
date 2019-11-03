package com.hcl.todolist.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.todolist.model.Task;
import com.hcl.todolist.repository.TaskRepo;
import com.hcl.todolist.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	TaskRepo taskRepo;

	@Override
	public Task getTaskById(long id) {
		
		Optional<Task> task = taskRepo.findById(id);
		
		return task.isPresent()?task.get():null;
	}

	@Override
	public boolean addTask(Task task) {
		
		return taskRepo.save(task) != null;
	}

	@Override
	public boolean updateTaskById(Task task) {
		
		return taskRepo.save(task) != null;
	}

	@Override
	public void deleteTaskById(long id) {
		
		taskRepo.deleteById(id);
	}

}
