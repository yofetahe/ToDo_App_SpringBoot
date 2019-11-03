package com.hcl.todolist.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.todolist.model.Task;
import com.hcl.todolist.model.ToDoList;
import com.hcl.todolist.service.TaskService;
import com.hcl.todolist.service.ToDoListService;

@RestController
@RequestMapping("/api")
public class TaskController {
	
	@Autowired
	TaskService taskService;
	@Autowired
	ToDoListService toDoListService;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/addTask")
	public ResponseEntity<ToDoList> addTask(@RequestBody Task task){

		boolean result = taskService.addTask(task);
		
		ToDoList t = toDoListService.getToDoListById(task.getToDoList().getId());

		if(result)
			return new ResponseEntity<ToDoList>(t, HttpStatus.OK);
		
		return null;
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/updateTask")
	public ResponseEntity<ToDoList> updateTask(@RequestBody Task task){
		
		boolean result = taskService.updateTaskById(task);
		
		if(result)
			return new ResponseEntity<ToDoList>(toDoListService.getToDoListById(task.getToDoList().getId()), HttpStatus.OK);
		
		return null;
	} 
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/getTaskById/{id}")
	public ResponseEntity<Task> getTaskById(@PathVariable long id){

		return new ResponseEntity<Task>(taskService.getTaskById(id), HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/getTaskListByToDoListId/{id}")
	public ResponseEntity<ToDoList> getTaskListByToDoListId(@PathVariable long id){
		
		List<ToDoList> toDoList = toDoListService.getAllToDoList();
		
		return new ResponseEntity<ToDoList>(toDoList.stream().filter(i -> i.getId() == id).collect(Collectors.toList()).get(0), HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping("/deleteTaskById/{toDo_id}/{task_id}")
	public ResponseEntity<ToDoList> deleteTaskById(@PathVariable long toDo_id, @PathVariable long task_id){

		taskService.deleteTaskById(task_id);
		
		ToDoList toDo = toDoListService.getToDoListById(toDo_id);
		
		return new ResponseEntity<ToDoList>(toDo, HttpStatus.ACCEPTED);
	}

}
