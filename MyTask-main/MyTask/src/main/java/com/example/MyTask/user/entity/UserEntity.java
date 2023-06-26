package com.example.MyTask.user.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.MyTask.tasks.dto.TaskDto;
import com.example.MyTask.tasks.entity.TaskEntity;
import com.example.MyTask.validation.anotation.NameIdExist;
import com.example.MyTask.validation.anotation.UniqueEmail;
import com.example.MyTask.validation.anotation.UniqueName;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class UserEntity {
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(updatable = false)
	private int id;
	
	@NotBlank
	private String name;
	
	private String displayName;
	
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	@Size(min = 5)
	private String password;
	
	@OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(name = "user_task",
	joinColumns = @JoinColumn(name = "user_id"),
	inverseJoinColumns = @JoinColumn(name = "task_id"))
 	Set<TaskEntity> tasks = new HashSet<>();
	
	public void addTask(UserEntity taskUser, int userId) {
		 
	}
}
