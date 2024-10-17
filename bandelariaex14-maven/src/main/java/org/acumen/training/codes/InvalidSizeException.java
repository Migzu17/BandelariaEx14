package org.acumen.training.codes;

public class InvalidSizeException extends Exception {
	private static final long serialVersionUID = -1392307077206809088L;
	private String message = "Unsupported character/string.";
	
	public InvalidSizeException() {}
	
	// replace message
	public InvalidSizeException(String message) {
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
