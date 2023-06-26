package com.example.MyTask.user.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.MyTask.util.HttpStatus;
import com.example.MyTask.validation.anotation.NameIdExist;
import com.example.MyTask.validation.anotation.TaskIdExist;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddTaskDto {
	@NotNull
	@NameIdExist
	@Size(min = 1)
	private int taskUserId;
	
	@NotBlank
	private String tilte;
	
	@NotBlank
	private String description;
	
	private int score;
	
	@NotNull
	private HttpStatus status;
}
