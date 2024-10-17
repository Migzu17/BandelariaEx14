package org.acumen.training.codes;

public class BadIndexException extends Exception {
	private static final long serialVersionUID = 577911624254513815L;
	private String message = "Bad Index.";
	
	public BadIndexException() {}
	
	// replace message
	public BadIndexException(String message) {
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
