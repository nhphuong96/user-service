package com.nhphuong.utilitytool.userservice.exception;

public class ValidationException extends Exception {

	private static final long serialVersionUID = 1890426528623702494L;

	public ValidationException() {
		super();
	}

	public ValidationException(String message, Throwable cause) {
		super(message, cause);
	}

	public ValidationException(String message) {
		super(message);
	}
	
	

}
