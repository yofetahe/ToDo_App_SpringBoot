package com.hcl.todolist.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "task")
@Getter @Setter
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	@Size(min = 4)
	private String task_title;
	
	@Column(nullable = true)
	private String task_description;
	
	@Column(nullable = false)
	private String due_date;
	
	@Column
	private int task_status;
	
	@Column(nullable = false)
	private String create_at;
	
	@Column(nullable = true)
	private String update_at;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "toDoList", nullable = false)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private ToDoList toDoList;
	
	@PrePersist
	void createdAt() {
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
		String strDate = dateFormat.format(date); 
	    this.create_at = strDate;
	    this.task_status = 1;
	}
}
