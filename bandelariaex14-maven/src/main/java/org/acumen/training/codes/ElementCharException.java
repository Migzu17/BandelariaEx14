package org.acumen.training.codes;

public class ElementCharException extends Exception {
	private static final long serialVersionUID = 4065746813960130340L;
	private String message = "Invalid element value = [character/String]";
	
	public ElementCharException() {}
	
	// replace message
	public ElementCharException(String message) {
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
