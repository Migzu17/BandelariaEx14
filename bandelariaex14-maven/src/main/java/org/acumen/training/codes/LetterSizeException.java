package org.acumen.training.codes;

public class LetterSizeException extends Exception {
	private static final long serialVersionUID = -8050838961686879348L;
	private String message = 
			"Invalid size. Letter/String input; number expected.";
	
	public LetterSizeException() {}
	
	// replace message
	public LetterSizeException(String message) {
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
