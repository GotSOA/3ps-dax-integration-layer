package com.bhnetwork.integration.transformer;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.api.transport.PropertyScope;
import org.mule.transformer.AbstractMessageTransformer;

import com.microsoft.schemas.dynamics._2008._01.documents.bhnsetupcomp3ps.AxdEntityBhnSetupComp3PS;
import com.microsoft.schemas.dynamics._2008._01.documents.bhnsetupcomp3ps.AxdbhnSetUpComp3PS;
import com.microsoft.schemas.dynamics._2008._01.services.BhnSetUpComp3PSServiceCreateRequest;

public class CanonicalToBhnSetUpComp3PSServiceCreateRequest extends
		AbstractMessageTransformer {

	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding)
			throws TransformerException {
		
		BhnSetUpComp3PSServiceCreateRequest req = new BhnSetUpComp3PSServiceCreateRequest();
		String partnerProfileId = message.getProperty("partnerProfileId", PropertyScope.SESSION).toString();
		
		AxdbhnSetUpComp3PS bhnSetUpComp3PS = new AxdbhnSetUpComp3PS();
		
		AxdEntityBhnSetupComp3PS entityBhnSetupComp3PS =  new AxdEntityBhnSetupComp3PS();
		entityBhnSetupComp3PS.setPartnerProfileId(partnerProfileId);
		entityBhnSetupComp3PS.setClazz("entity");
		
		bhnSetUpComp3PS.getBhnSetupComp3PS().add(entityBhnSetupComp3PS);
		req.setBhnSetUpComp3PS(bhnSetUpComp3PS);
		
		return req;
	}
}