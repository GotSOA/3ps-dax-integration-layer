package com.bhnetwork.integration.exception;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class ILException extends Exception{

	Logger logger = Logger.getLogger(ILException.class.getName());
	
	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public ILException(String message){
		this.message = message;
		logger.log(Level.ERROR, message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
