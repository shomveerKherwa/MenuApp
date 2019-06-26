package com.moment.validation;

import java.util.Date;

import javax.validation.UnexpectedTypeException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	  @Override 
	  protected ResponseEntity<Object>handleMethodArgumentNotValid( MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status,
	  WebRequest request) 
	  { 
		  System.out.println("000000000"+ex.toString());
	  ErrorDetails errorDetails = new ErrorDetails(new Date(), "Validation Failed", ex.getBindingResult().getFieldError().getDefaultMessage()); 
	  return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST); 
	  }
	 
	 
	 

}