package com.audition;

/**
 * Vending Machine throws this exception when the user request for a product which is sold out
 * @author saritha
 *
 */
public class SoldOutException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String message;

	public SoldOutException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
	
}
