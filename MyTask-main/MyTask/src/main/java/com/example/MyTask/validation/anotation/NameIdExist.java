package com.example.MyTask.validation.anotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.example.MyTask.validation.validator.NameIdExistValidator;

@Constraint(validatedBy = NameIdExistValidator.class)
@Retention(RUNTIME)
@Target({ TYPE, FIELD })
public @interface NameIdExist {
	public String message() default "This ID is not exist";
	
	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}
