package com.example.MyTask.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.example.MyTask.user.service.UserService;
import com.example.MyTask.validation.anotation.NameIdExist;

public class NameIdExistValidator implements ConstraintValidator<NameIdExist, Integer>{
	private UserService service;
	
	public NameIdExistValidator(UserService userService) {
		service = userService;
	}
	
	@Override
	public void initialize(NameIdExist constraintAnnotation) {
		
	}


	@Override
	public boolean isValid(Integer nameId, ConstraintValidatorContext context) {
		if(nameId == null)
			return false;
		boolean isTaken = service.isExistNameId(nameId);
		
		if(isTaken)
			return true;
		
		return false;
	}

}
