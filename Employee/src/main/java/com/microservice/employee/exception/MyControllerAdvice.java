package com.microservice.employee.exception;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.microservice.employee.entity.EmployeeSignUp;

@ControllerAdvice
public class MyControllerAdvice {

	@ExceptionHandler(EmptyException.class)
	public ResponseEntity<String>handleEmpty(EmptyException empty){
		return new ResponseEntity<String>("Input field is empty, please look into it",HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String>noSuchElement(NoSuchElementException empty){
		return new ResponseEntity<String>("No value present in the DB, Please change the Request",HttpStatus.NOT_FOUND);
		
	}
	
}
