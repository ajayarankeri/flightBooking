package com.hcl.flightReservation.exception;

public class InvalidUserDataException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidUserDataException() {
		// TODO Auto-generated constructor stub
	}
	
	public InvalidUserDataException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InvalidUserDataException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
