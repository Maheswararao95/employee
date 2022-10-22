package com.imageinnovate.employee.exception;

import org.springframework.validation.BindingResult;

public class InvalidRequestParameterException extends RuntimeException {
	private static final long serialVersionUID = 4430322405316896401L;
	
	private BindingResult bindingResult;
	
	public InvalidRequestParameterException() {
		super();
	}
	
	public InvalidRequestParameterException(String msg) {
		super(msg);
	}
	
	public InvalidRequestParameterException(String message, BindingResult result) {
		super(message);
		this.bindingResult = result;
	}

	public BindingResult getBindingResult() {
		return bindingResult;
	}

	public void setBindingResult(BindingResult bindingResult) {
		this.bindingResult = bindingResult;
	}
}
