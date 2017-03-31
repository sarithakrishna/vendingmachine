package com.audition;

/**
 * Exception thrown by Vending Machine when invalid coin inserted
 * @author saritha
 *
 */
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
