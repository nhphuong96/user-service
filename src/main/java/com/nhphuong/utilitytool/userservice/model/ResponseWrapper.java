package com.nhphuong.utilitytool.userservice.model;

public class ResponseWrapper<T> {
	private T body;
	private String message;
	private boolean success;

	public ResponseWrapper(T body, String message, boolean success) {
		super();
		this.body = body;
		this.message = message;
		this.success = success;
	}

	public T getBody() {
		return body;
	}

	public void setBody(T body) {
		this.body = body;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

}
