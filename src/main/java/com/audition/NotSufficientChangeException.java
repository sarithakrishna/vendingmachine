package com.audition;

/**
 * This Exception class for Vending Machine does not have enough change for the request
 * @author saritha
 *
 */
public class NotSufficientChangeException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	private String message;

	public NotSufficientChangeException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
		
		
	

}
