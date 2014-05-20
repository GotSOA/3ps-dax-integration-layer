package com.bhnetwork.integration.transformer;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.api.transport.PropertyScope;
import org.mule.transformer.AbstractMessageTransformer;
import org.tempuri.BhnCleanUpMegatronServiceCreateRequest;

import com.microsoft.schemas.dynamics._2008._01.documents.bhncleanupmegatron.AxdEntityBhnCleanUpMegatron;
import com.microsoft.schemas.dynamics._2008._01.documents.bhncleanupmegatron.AxdbhnCleanUpMegatron;

public class CanonicalToBhnCleanUpMegatronServiceCreateRequest extends
		AbstractMessageTransformer {

	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding)
			throws TransformerException {
		
		BhnCleanUpMegatronServiceCreateRequest req = new BhnCleanUpMegatronServiceCreateRequest();
		String partnerProfileId = message.getProperty("partnerProfileId", PropertyScope.SESSION).toString();
		
		AxdbhnCleanUpMegatron bhnCleanUpMegatron = new AxdbhnCleanUpMegatron();
		
		AxdEntityBhnCleanUpMegatron entityBhnCleanUpMegatron = new AxdEntityBhnCleanUpMegatron();
		entityBhnCleanUpMegatron.setPartnerprofileId(partnerProfileId);
		//XML Attribute required
		entityBhnCleanUpMegatron.setClazz("entity");//TODO Not in SPEC
		
		bhnCleanUpMegatron.getBhnCleanUpMegatron().add(entityBhnCleanUpMegatron);
		
		req.setBhnCleanUpMegatron(bhnCleanUpMegatron);
		
		return req;
	}
}
