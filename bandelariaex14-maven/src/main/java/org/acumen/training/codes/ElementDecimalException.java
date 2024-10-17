package org.acumen.training.codes;

public class ElementDecimalException extends Exception {
	private static final long serialVersionUID = 7848944490269706026L;
	private String message = "Invalid element value = [floating-point]";
	
	public ElementDecimalException() {}
	
	// replace message
	public ElementDecimalException(String message) {
		this.message = message; 
	}

	@Override
	public String getMessage() {
		return this.message;
	}
	
	@Override
	public void printStackTrace() {
		System.err.println(this.message);
	}

}
