package com.example.demo.exception;


public class MissingAtrributeException extends RuntimeException{

	private static final long serialVersionUID = 2018144011588579333L;

	public MissingAtrributeException() {
		super();
	}

	public MissingAtrributeException(String message) {
		super(message);
	}

	
}
