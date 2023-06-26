package com.example.MyTask.tasks.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.example.MyTask.util.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateTaskDto {
	
	@NotBlank
	private String tilte;
	
	@NotBlank
	private String description;
	
	private int score;
	
	@NotNull
	private HttpStatus status;
}
