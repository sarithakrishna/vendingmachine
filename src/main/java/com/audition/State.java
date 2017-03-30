package com.audition;

public enum State {

	DEFAULT("INSERT COIN"), ITEM_DISPOSED("THANK YOU"), NO_CHANGE_DEFAULT("INSERT EXACT CHANGE ONLY");

	private State(String message) {
		this.message = message;
	}

	private String message;

	public String getMessage() {
		return message;
	}

}
