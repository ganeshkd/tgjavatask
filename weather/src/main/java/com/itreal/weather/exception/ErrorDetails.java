package com.itreal.weather.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorDetails {

	private String date;
	private String message;
	private String path;
	private HttpStatus status;
	private Object error;
	
}
