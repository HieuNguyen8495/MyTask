package com.example.MyTask.common;

import java.util.ArrayList;
import java.util.List;


public class ValidationErrorsDto {
	private List<ValidationErrorDto> validationErrors = new ArrayList<>();

    	public void addValidationError(String path, String message) {
    		validationErrors.add(new ValidationErrorDto(path, message));
    }
    
    
    	public void setValidationErrors(List<ValidationErrorDto> validationErrors) {
    		this.validationErrors = validationErrors;
	}


    	public List<ValidationErrorDto> getValidationErrors() {
    		return validationErrors;
	}

}
