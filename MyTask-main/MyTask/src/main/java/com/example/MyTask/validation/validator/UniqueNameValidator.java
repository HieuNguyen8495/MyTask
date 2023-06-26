package com.example.MyTask.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.example.MyTask.user.service.UserService;
import com.example.MyTask.validation.anotation.UniqueName;

public class UniqueNameValidator implements ConstraintValidator<UniqueName, String> {
	private UserService service;
	
	public UniqueNameValidator(UserService userService) {
		service = userService;
	}
	
	@Override
	public void initialize(UniqueName constraintAnnotation) {
	}

	@Override
	public boolean isValid(String name, ConstraintValidatorContext context) {
		if(name == null)
			return false;
		
		boolean isTaken = service.isTakenName(name);
		
		if(!isTaken)
			return true;
		
		return false;
	}

}
