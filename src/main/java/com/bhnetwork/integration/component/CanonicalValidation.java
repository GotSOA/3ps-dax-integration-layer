package com.bhnetwork.integration.component;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;

import com.bhnetwork.integration.exception.BadRequestException;
import com.bhnetwork.integration.pppstodax.canonical.PartnerProfile;

public class CanonicalValidation implements Callable{

	private Validator validator;

	public Validator getValidator() {
		return validator;
	}

	public void setValidator(Validator validator) {
		this.validator = validator;
	}

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		PartnerProfile partnerProfile = (PartnerProfile )eventContext.getMessage().getPayload();
		Set<ConstraintViolation<PartnerProfile>> violationSet = validator.validate(partnerProfile);
		if(!violationSet.isEmpty()){
			throw new BadRequestException(violationSet);//TODO 
		}
		return partnerProfile;
	}

}
