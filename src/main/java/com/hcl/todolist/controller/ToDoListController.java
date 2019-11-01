package com.hcl.todolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.todolist.model.ToDoList;
import com.hcl.todolist.service.ToDoListService;

@RestController
@RequestMapping(path = "/api")
public class ToDoListController {
	
	@Autowired
	ToDoListService toDoListService;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/getAllToDoList")
	public ResponseEntity<List<ToDoList>> getAllToDoList(){
		
		return new ResponseEntity<List<ToDoList>>(toDoListService.getAllToDoList(), HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/getToDoListById/{id}")
	public ResponseEntity<ToDoList> getToDoListById(@PathVariable long id){
		
		return new ResponseEntity<ToDoList>(toDoListService.getToDoListById(id), HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping(path="/addToDoList", consumes = "application/json", produces = "application/json")
	public @ResponseBody List<ToDoList> addToDoList(@RequestBody ToDoList toDoList){
		
		ToDoList rslt = toDoListService.addToDoList(toDoList);
		
		if(rslt != null) {		
			return toDoListService.getAllToDoList();
		}
		return null;
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/updateToDoList")
	public ResponseEntity<List<ToDoList>> updateToDoList(@RequestBody ToDoList toDoList){
		
		boolean rslt = toDoListService.updateToDoListById(toDoList);
		
		if(rslt) {		
			return new ResponseEntity<List<ToDoList>>(toDoListService.getAllToDoList(), HttpStatus.OK);
		} 
		return null;
	}
}
