package com.bhnetwork.integration.exception;

import java.util.Set;

import javax.validation.ConstraintViolation;

import com.bhnetwork.integration.pppstodax.canonical.PartnerProfile;

public class BadRequestException extends ILException{
	
	private static final long serialVersionUID = 1L;

	public BadRequestException(Set<ConstraintViolation<PartnerProfile>> violationSet){
		super(buildErrorMessage(violationSet));
	}
	
	private static String buildErrorMessage(Set<ConstraintViolation<PartnerProfile>> violationSet){
		StringBuilder errorMessage = new StringBuilder("Bad Request: \n"); 
		for(ConstraintViolation<PartnerProfile> violation: violationSet){
			errorMessage.append(violation.getPropertyPath() + ":" + violation.getMessage() + "\n");
		}
		return errorMessage.toString();
	}
	
}
