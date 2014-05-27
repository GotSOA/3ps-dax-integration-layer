package com.bhnetwork.integration.transformer;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;

import com.bhnetwork.integration.pppstodax.canonical.Division;
import com.bhnetwork.integration.pppstodax.canonical.PartnerProfile;
import com.microsoft.schemas.dynamics._2008._01.services.BhnDivision3PSServiceCreateRequest;

public class CanonicalToBhnDivision3PSServiceCreateRequest extends
		AbstractMessageTransformer {

	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding)
			throws TransformerException {
		Division division = ((PartnerProfile) message.getPayload()).getCompany().getCpDivision().get(0);
		BhnDivision3PSServiceCreateRequest req = new BhnDivision3PSServiceCreateRequest();
		
		return req;
	}
}
