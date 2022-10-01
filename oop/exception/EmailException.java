package com.lab1.oop.exception;

public class EmailException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmailException(String errorMessage) {
		super(errorMessage);
	}
}
