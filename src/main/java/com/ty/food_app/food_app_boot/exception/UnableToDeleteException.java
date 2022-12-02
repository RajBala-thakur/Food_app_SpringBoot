package com.ty.food_app.food_app_boot.exception;

public class UnableToDeleteException extends RuntimeException {
	private String message = "UnableToDeleteException";

	public UnableToDeleteException(String message) {
		super();
		this.message = message;

	}

	public UnableToDeleteException() {

	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}

}
