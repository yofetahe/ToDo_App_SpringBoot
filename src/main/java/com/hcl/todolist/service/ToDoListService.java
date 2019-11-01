package com.hcl.todolist.service;

import java.util.List;

import com.hcl.todolist.model.ToDoList;

public interface ToDoListService {
	
	public List<ToDoList> getAllToDoList();
	public ToDoList getToDoListById(long id);
	public ToDoList addToDoList(ToDoList toDoList);
	public boolean updateToDoListById(ToDoList toDoList);
	public void deleteToDoListById(long id);
}
