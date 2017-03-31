package com.audition;

/**
 * An Exception thrown by vending machine when the customer tries to collect an item without
 * paying full amount
 * @author saritha
 *
 */
public class NotFullPaidException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public NotFullPaidException(String message, double remaining) {
		this.message = message;
		this.remaining = remaining;
	}

	private String message;
	
	private double remaining;

	public String getMessage() {
		return message;
	}

	public double getRemaining() {
		return remaining;
	}
	
	

}
