package com.example.MyTask.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidationErrorDto {
	    private String path;
	    private String message;

	    public ValidationErrorDto(String path, String message) {
	        this.path = path;
	        this.message = message;
	    }

	}

