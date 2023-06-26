package com.example.MyTask.tasks.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.example.MyTask.user.entity.UserEntity;
import com.example.MyTask.util.HttpStatus;
import com.example.MyTask.validation.anotation.TaskIdExist;

import lombok.Getter;

import lombok.Setter;

@Getter
@Setter
public class TaskDto {
	@NotNull
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@TaskIdExist
	private int id;
	
	@NotBlank
	private String tilte;
	
	@NotBlank
	private String description;
	
	private int score;
	
	@NotNull
	private HttpStatus status;
	
	Set<UserEntity> users = new HashSet<>();
}
