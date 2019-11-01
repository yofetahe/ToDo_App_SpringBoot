package com.hcl.todolist.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "to_do_list")
@Getter @Setter
public class ToDoList {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	@Size(min = 4)
	private String title;
	
	@Column(nullable = false)
	private String description;
	
	@Column(nullable = false)
	private String create_at;
	
	@Column(nullable = true)
	private String update_at;
	
	@OneToMany(mappedBy = "toDoList", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnoreProperties("toDoList")
	private List<Task> task = new ArrayList<Task>();
	
	@PrePersist
	void createdAt() {
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
		String strDate = dateFormat.format(date); 
	    this.create_at = strDate;
	}
	
}
