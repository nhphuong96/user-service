package com.nhphuong.utilitytool.userservice.exception;

public class EntityExistsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8657723536942067557L;

	public EntityExistsException() {
		super();
	}

	public EntityExistsException(String message, Throwable cause) {
		super(message, cause);
	}

	public EntityExistsException(String message) {
		super(message);
	}

}
