package com.example.demo.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.exception.MissingAtrributeException;

@ControllerAdvice
public class GlobalExceptionHandler {
  
	
	@ExceptionHandler(value=MissingAtrributeException.class)
	public ResponseEntity<String> missingProperty(Exception ex){
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}
}
