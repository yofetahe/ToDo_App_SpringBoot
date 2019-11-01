package com.hcl.todolist.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.todolist.model.ToDoList;
import com.hcl.todolist.repository.ToDoListRepo;
import com.hcl.todolist.service.ToDoListService;

@Service
public class ToDoListServiceImpl implements ToDoListService {
	
	@Autowired
	ToDoListRepo toDoListRepo;
	
	@Override
	public List<ToDoList> getAllToDoList() {		
		
		return (List<ToDoList>) toDoListRepo.findAll();
	}

	@Override
	public ToDoList getToDoListById(long id) {
		
		Optional<ToDoList> toDoList = toDoListRepo.findById(id);
		
		return toDoList.isPresent()?toDoList.get():null;
	}

	@Override
	public ToDoList addToDoList(ToDoList toDoList) {
		
		return toDoListRepo.save(toDoList);
	}

	@Override
	public boolean updateToDoListById(ToDoList toDoList) {
		
		return toDoListRepo.save(toDoList) != null;
	}

	@Override
	public void deleteToDoListById(long id) {
		
		toDoListRepo.deleteById(id);
	}

}
