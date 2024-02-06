package com.exception.custom.creation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExcetionHandler {

	@ExceptionHandler(AgeNotPermittedException.class)
	public ResponseEntity<String> handleAgeNotPermittedException(AgeNotPermittedException ex){
		String message = ex.getMessage();
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
	}
	
	
}
