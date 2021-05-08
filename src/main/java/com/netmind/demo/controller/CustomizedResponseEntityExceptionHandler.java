package com.netmind.demo.controller;

import java.util.Date;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.netmind.demo.model.EmployeeNotFoundException;
import com.netmind.demo.model.ErrorDetails;

//https://www.springboottutorial.com/spring-boot-exception-handling-for-rest-services
@RestControllerAdvice
public class CustomizedResponseEntityExceptionHandler
		extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EmployeeNotFoundException.class)
	public final ResponseEntity<ErrorDetails> handleUserNotFoundException(
			EmployeeNotFoundException ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(),
				ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<ErrorDetails> dispatchNotFound(
			NoSuchElementException ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(),
				ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
}
