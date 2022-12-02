package com.ty.food_app.food_app_boot.exception;

public class UnableToUpdateException extends RuntimeException {
	private String message="Unable To Update Exception";

	
	
	
	public UnableToUpdateException(String message) {
		super();
		this.message = message;
	}




	public UnableToUpdateException() {
	
	}




	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}
	

}
