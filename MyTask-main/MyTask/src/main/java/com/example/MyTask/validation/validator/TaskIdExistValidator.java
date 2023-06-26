package com.example.MyTask.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.example.MyTask.user.service.UserService;
import com.example.MyTask.validation.anotation.TaskIdExist;

public class TaskIdExistValidator implements ConstraintValidator<TaskIdExist, Integer>{
	private UserService service;
	
	public TaskIdExistValidator(UserService userService) {
		service = userService;
	}
	
	
	@Override
	public void initialize(TaskIdExist constraintAnnotation) {
	}


	@Override
	public boolean isValid(Integer taskId, ConstraintValidatorContext context) {
		boolean isTaken = service.isExistTaskId(taskId);
		if(taskId == null)
			return false;
		
		if(isTaken)
			return true;
					
		return false;
	}

}
