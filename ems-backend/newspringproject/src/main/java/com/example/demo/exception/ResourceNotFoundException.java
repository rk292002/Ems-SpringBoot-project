package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)     //sends error message and http status to client when requested user not found in list
public class ResourceNotFoundException extends RuntimeException {
	public ResourceNotFoundException(String message) {
    super(message);
    
	}
}
