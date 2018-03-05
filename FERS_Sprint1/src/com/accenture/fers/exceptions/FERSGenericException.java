package com.accenture.fers.exceptions;


/**
 * Custom Exception class for overriding SQL and CLASSNOTFOUND exceptions
 */
@SuppressWarnings("serial")
public class FERSGenericException extends RuntimeException {


	public FERSGenericException(String message, Throwable object)
	{
		super(message,object);

	}

	public FERSGenericException(String message) {
		super(message);
	}

}
