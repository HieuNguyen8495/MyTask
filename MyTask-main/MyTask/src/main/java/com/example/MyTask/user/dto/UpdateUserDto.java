package com.example.MyTask.user.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.MyTask.validation.anotation.NameIdExist;
import com.example.MyTask.validation.anotation.UniqueEmail;
import com.example.MyTask.validation.anotation.UniqueName;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserDto {
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(updatable = false)
	@NameIdExist
	private int id;
	
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
