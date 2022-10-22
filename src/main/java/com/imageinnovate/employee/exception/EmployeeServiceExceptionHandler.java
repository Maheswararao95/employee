package com.imageinnovate.employee.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class EmployeeServiceExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		ErrorResponse errorResponse = new ErrorResponse("Server error ", details);
		return new ResponseEntity<Object>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(InvalidRequestParameterException.class)
	public final ResponseEntity<Object> hanldeInvalidRequestParameterException(InvalidRequestParameterException ex,
			WebRequest webRequest) {
		List<String> details = new ArrayList<>();
		BindingResult bindingResult = ex.getBindingResult();

		if (bindingResult != null) {
			for (ObjectError error : bindingResult.getAllErrors()) {
				FieldError fieldError = (FieldError) error;
				details.add(fieldError.getField() + " " + fieldError.getDefaultMessage());
			}
		}

		ErrorResponse errorResponse = new ErrorResponse(ex.getLocalizedMessage(), details);
		return new ResponseEntity<Object>(errorResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(RequestFailedException.class)
	public final ResponseEntity<Object> handleRequestFailedException(RequestFailedException exception,
			WebRequest webRequest) {
		ErrorResponse errorResponse = new ErrorResponse(exception.getLocalizedMessage(), exception.getDetails());
		return new ResponseEntity<Object>(errorResponse, HttpStatus.BAD_REQUEST);
	}
}
