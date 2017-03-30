package com.audition;

public class InvalidInsertCoinsException extends RuntimeException {

	private String message;

	public InvalidInsertCoinsException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
