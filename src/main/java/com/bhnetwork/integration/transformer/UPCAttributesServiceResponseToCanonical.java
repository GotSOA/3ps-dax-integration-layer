package com.bhnetwork.integration.transformer;

import java.util.Iterator;
import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.api.transport.PropertyScope;
import org.mule.transformer.AbstractMessageTransformer;
import com.bhnetwork.integration.pppstodax.canonical.PartnerProfile;
import com.microsoft.schemas.dynamics._2006._02.documents.entitykey.EntityKey;
import com.microsoft.schemas.dynamics._2006._02.documents.entitykeylist.EntityKeyList;
import com.microsoft.schemas.dynamics._2008._01.services.BhnUPCAttributes3PSServiceCreateResponse;

public class UPCAttributesServiceResponseToCanonical extends AbstractMessageTransformer {

	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding) throws TransformerException {
			
		System.out.println("UPCAttributesServiceResponseToCanonical: Payload is of type: " + message.getPayload().getClass());
		
		BhnUPCAttributes3PSServiceCreateResponse resp = (BhnUPCAttributes3PSServiceCreateResponse) message.getPayload();
		
		EntityKeyList entityKeyList = resp.getEntityKeyList();
		
		// to iterate through the list
		Iterator<EntityKey> entityKeyListIterator = entityKeyList.getEntityKey().listIterator();
		
		System.out.println("\n Got a UPCAttributes Response List of size = " + entityKeyList.getEntityKey().size());
		
        PartnerProfile canonPartnerProfile = (PartnerProfile) message.getProperty("canon", PropertyScope.SESSION);
        int idx=0;
        EntityKey entKey=null;
        
        while (entityKeyListIterator.hasNext()) {	
        	
        	entKey = entityKeyListIterator.next();
        	
        	canonPartnerProfile.getCompany().getCpDivision().get(0).getProducts().get(idx).getIid().setItemId(entKey.getKeyData().getKeyField().get(0).getValue());
        	canonPartnerProfile.getCompany().getCpDivision().get(0).getProducts().get(idx).getIid().setBhnGUID(entKey.getKeyData().getKeyField().get(3).getValue());

        	// TODO: put this logger pattern elsewhere
    		// logging itemId & bhnGUID
    		System.out.println("Log itemId=" + canonPartnerProfile.getCompany().getCpDivision().get(0).getProducts().get(idx).getIid().getItemId() + " and bhnGUID=" + canonPartnerProfile.getCompany().getCpDivision().get(0).getProducts().get(idx).getIid().getBhnGUID());
    		idx++;
        	entKey=null;
        }
        // update the canonical in session after enrichment
		message.setProperty("canon", canonPartnerProfile, PropertyScope.SESSION);
		
		return null;	// payload is no longer used in the flow past this transformer
	}
}