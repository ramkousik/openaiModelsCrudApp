package com.openai.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ModelNotFoundException extends RuntimeException{
	
	public ModelNotFoundException(String message) {
		
		super(message);
		
	}

}
