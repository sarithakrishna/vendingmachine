package com.audition;

public class InvalidInsertCoinsException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String message;

	public InvalidInsertCoinsException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
