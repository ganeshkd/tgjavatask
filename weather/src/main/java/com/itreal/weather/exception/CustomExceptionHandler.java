package com.itreal.weather.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetails> handleAllExceptions(Exception ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date().toString(), "INTERNAL_SERVER_ERROR", request.getDescription(false),
				HttpStatus.NO_CONTENT, ex.getMessage());
		ex.printStackTrace();
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public final ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date().toString(), "RESOURCE_NOT_FOUND", request.getDescription(false),
				HttpStatus.UNAUTHORIZED, ex.getMessage());
		ex.printStackTrace();
		return new ResponseEntity<>(errorDetails, HttpStatus.UNAUTHORIZED);
	}
	
}
