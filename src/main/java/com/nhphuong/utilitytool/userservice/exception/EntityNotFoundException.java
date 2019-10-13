package com.nhphuong.utilitytool.userservice.exception;

public class EntityNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1074667811417325669L;

	public EntityNotFoundException() {
		super();
	}

	public EntityNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public EntityNotFoundException(String message) {
		super(message);
	}

}
