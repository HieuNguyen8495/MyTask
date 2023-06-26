package com.example.MyTask.config;


import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.MyTask.common.ValidationErrorsDto;

@ControllerAdvice
@RestController
public class ExceptionController {

	@ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationErrorsDto handleConstraintViolationException(MethodArgumentNotValidException cvException) {
        return buildValidationErrorDto(cvException.getFieldErrors());
    }

    private ValidationErrorsDto buildValidationErrorDto(List<FieldError> violations) {
        ValidationErrorsDto errorDto = new ValidationErrorsDto();
        for (FieldError cv : violations)
        {
            errorDto.addValidationError(cv.getField(), cv.getDefaultMessage());
        }
        return errorDto;
    }
    
}


