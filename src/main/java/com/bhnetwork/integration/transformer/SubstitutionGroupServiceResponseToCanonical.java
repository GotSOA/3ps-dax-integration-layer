package com.bhnetwork.integration.transformer;

import java.util.Iterator;
import java.util.List;
import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.api.transport.PropertyScope;
import org.mule.transformer.AbstractMessageTransformer;
import com.bhnetwork.integration.pppstodax.canonical.PartnerProfile;
import com.microsoft.schemas.dynamics._2006._02.documents.entitykey.EntityKey;

public class SubstitutionGroupServiceResponseToCanonical extends AbstractMessageTransformer {

	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding) throws TransformerException {
			
		@SuppressWarnings("unchecked")
		List<EntityKey> entityKeyList = (List<EntityKey>) message.getPayload();
		
		// iterate through the list
		System.out.println("\n Got a SubstitutionGroup Response List of size = " + entityKeyList.size());
        Iterator<EntityKey> entityKeyIterator = entityKeyList.iterator();
        PartnerProfile canonPartnerProfile = (PartnerProfile) message.getProperty("canon", PropertyScope.SESSION);
        int idx=0;
        while (entityKeyIterator.hasNext()) {
        	System.out.println("\n Adding product(" + idx + ")");
        	canonPartnerProfile.getCompany().getCpDivision().get(0).getProducts().get(idx).getSubstGrp().setSubGroupId(entityKeyIterator.next().getKeyData().getKeyField().get(0).getValue());
        	canonPartnerProfile.getCompany().getCpDivision().get(0).getProducts().get(idx).getSubstGrp().setSubstitutionBrandDenomDescription(entityKeyIterator.next().getKeyData().getKeyField().get(1).getValue());
        	canonPartnerProfile.getCompany().getCpDivision().get(0).getProducts().get(idx).getSubstGrp().setGuid(entityKeyIterator.next().getKeyData().getKeyField().get(2).getValue());
        	canonPartnerProfile.getCompany().getCpDivision().get(0).getProducts().get(idx).getSubstGrp().setBrandRecId(entityKeyIterator.next().getKeyData().getKeyField().get(3).getValue());
        	idx++;
        }
		message.setProperty("canon", canonPartnerProfile, PropertyScope.SESSION);
		return null;	// payload is no longer used in the flow past this transformer
	}
}
