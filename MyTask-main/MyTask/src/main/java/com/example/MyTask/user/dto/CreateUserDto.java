package com.example.MyTask.user.dto;



import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.example.MyTask.validation.anotation.UniqueEmail;
import com.example.MyTask.validation.anotation.UniqueName;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class CreateUserDto {
	
	@NotBlank
	@UniqueName
	private String name;
	
	private String displayName;
	
	@NotBlank
	@Email
	@UniqueEmail
	private String email;
	
	@NotBlank
	@Size(min = 5)
	private String password;
}
