package com.example.MyTask.tasks.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.example.MyTask.user.entity.UserEntity;
import com.example.MyTask.util.HttpStatus;
import com.example.MyTask.validation.anotation.TaskIdExist;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class TaskEntity {
	@NotNull
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank
	private String tilte;
	
	@NotBlank
	private String description;
	
	private int score;
	
	@NotNull
	private HttpStatus status;
	
	@OneToMany(mappedBy = "tasks")
	Set<UserEntity> users = new HashSet<>();
}
