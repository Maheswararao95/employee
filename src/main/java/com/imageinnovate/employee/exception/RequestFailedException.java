package com.imageinnovate.employee.exception;

import java.util.List;

public class RequestFailedException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private List<String> details;
	
	public RequestFailedException() {
		super("Request failed.");
	}
	
	public RequestFailedException(String msg) {
		super(msg);
	}
	
	public RequestFailedException(String msg, List<String> details) {
		super(msg);
		this.details = details;
	}

	public List<String> getDetails() {
		return details;
	}

	public void setDetails(List<String> details) {
		this.details = details;
	}
}
