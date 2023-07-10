package com.mayank.udemy.mobileapp.MobileAppBasic.Exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.mayank.udemy.mobileapp.MobileAppBasic.Model.Response.ErrorMessage;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value= {Exception.class})
	public ResponseEntity<Object>handleAnyException(Exception e, WebRequest request){
		
		String errorMessageDescription = e.getLocalizedMessage();
		if(errorMessageDescription == null) {
			errorMessageDescription= e.toString();
		}
		
		ErrorMessage errorMessage = new ErrorMessage(new Date(), errorMessageDescription);
		
		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@ExceptionHandler(value= {NullPointerException.class, UserServiceException.class})
	public ResponseEntity<Object>handleAnyNullPointerException(Exception e, WebRequest request){
		
		String errorMessageDescription = e.getLocalizedMessage();
		if(errorMessageDescription == null) {
			errorMessageDescription= e.toString();
		}
		
		ErrorMessage errorMessage = new ErrorMessage(new Date(), errorMessageDescription);
		
		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
