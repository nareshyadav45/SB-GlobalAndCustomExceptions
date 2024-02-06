package com.exception.custom.creation;

public class AgeNotPermittedException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public AgeNotPermittedException() {
		
	}
    
   public AgeNotPermittedException(String message) {
	   super(message);
		
	}
	
}
