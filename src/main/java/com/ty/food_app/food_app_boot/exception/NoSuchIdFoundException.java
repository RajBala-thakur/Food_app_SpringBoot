package com.ty.food_app.food_app_boot.exception;

public class NoSuchIdFoundException extends RuntimeException {
	
	private String message="No Such Id Found Exception";

	
	
	public NoSuchIdFoundException(String message) {
		super();
		this.message = message;
	}
	



	public NoSuchIdFoundException() {
		
	}




	@Override
	public String getMessage() {
		
		return message;
	}
	

}
