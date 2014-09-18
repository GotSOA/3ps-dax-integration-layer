package com.bhnetwork.integration.transformer;

import java.util.Iterator;
import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.api.transport.PropertyScope;
import org.mule.transformer.AbstractMessageTransformer;
import com.bhnetwork.integration.pppstodax.canonical.PartnerProfile;
import com.microsoft.schemas.dynamics._2006._02.documents.entitykey.EntityKey;
import com.microsoft.schemas.dynamics._2006._02.documents.entitykeylist.EntityKeyList;
import org.tempuri.UPCSubGroupTableServiceCreateResponse;

public class SubstitutionGroupServiceResponseToCanonical extends AbstractMessageTransformer {

	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding) throws TransformerException {
			
		//System.out.println("SubstitutionGroupServiceResponseToCanonical: Payload is of type: " + message.getPayload().getClass());
		
		UPCSubGroupTableServiceCreateResponse resp = (UPCSubGroupTableServiceCreateResponse) message.getPayload();
		
		EntityKeyList entityKeyList = resp.getEntityKeyList();
		
		// to iterate through the list
		Iterator<EntityKey> entityKeyListIterator = entityKeyList.getEntityKey().listIterator();
		
		// System.out.println("\n Got a SubstitutionGroup Response List of size = " + entityKeyList.getEntityKey().size());
		
        PartnerProfile canonPartnerProfile = (PartnerProfile) message.getProperty("canon", PropertyScope.SESSION);
        int idx=0;
        EntityKey entKey=null;
        
        while (entityKeyListIterator.hasNext()) {	
        	
        	entKey = entityKeyListIterator.next();
        	
        	canonPartnerProfile.getCompany().getCpDivision().get(0).getProducts().get(idx).getSubstGrp().setSubGroupId(entKey.getKeyData().getKeyField().get(0).getValue());
        	canonPartnerProfile.getCompany().getCpDivision().get(0).getProducts().get(idx).getSubstGrp().setSubstitutionBrandDenomDescription(entKey.getKeyData().getKeyField().get(1).getValue());
        	canonPartnerProfile.getCompany().getCpDivision().get(0).getProducts().get(idx).getSubstGrp().setGuid(entKey.getKeyData().getKeyField().get(2).getValue());
        	canonPartnerProfile.getCompany().getCpDivision().get(0).getProducts().get(idx).getSubstGrp().setBrandRecId(entKey.getKeyData().getKeyField().get(3).getValue());

        	// TODO: put this logger pattern elsewhere
    		// logging guid & brandRecId
    		System.out.println("guid=" + canonPartnerProfile.getCompany().getCpDivision().get(0).getProducts().get(idx).getSubstGrp().getGuid() + " and brandRecId=" + canonPartnerProfile.getCompany().getCpDivision().get(0).getProducts().get(idx).getSubstGrp().getBrandRecId());
        	idx++;
        	entKey=null;
        }
        // update the canonical in session after enrichment
		message.setProperty("canon", canonPartnerProfile, PropertyScope.SESSION);
		
		return null;	// payload is no longer used in the flow past this transformer
	}
}
