package com.example.MyTask.validation.validator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.example.MyTask.user.service.UserService;
import com.example.MyTask.validation.anotation.UniqueEmail;


public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {
	private UserService service;
	
	public UniqueEmailValidator(UserService userService) {
		service = userService;
	}
	
	@Override
	public void initialize(UniqueEmail constraintAnnotation) {
	}

	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		if(email == null)
			return false;
		
		boolean isTaken = service.isTakenEmail(email);
		
		if(!isTaken)
			return true;
		return false;
	}
	
	
	
}
