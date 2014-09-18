package com.bhnetwork.integration.transformer;

import java.util.Iterator;
import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.api.transport.PropertyScope;
import org.mule.transformer.AbstractMessageTransformer;
import com.bhnetwork.integration.pppstodax.canonical.PartnerProfile;
import com.microsoft.schemas.dynamics._2006._02.documents.entitykey.EntityKey;
import com.microsoft.schemas.dynamics._2006._02.documents.entitykeylist.EntityKeyList;
import com.microsoft.schemas.dynamics._2008._01.services.CustomerServiceCreateResponse;


public class StoreServiceResponseToCanonical extends AbstractMessageTransformer {

	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding) throws TransformerException {
			
		System.out.println("StoreServiceResponseToCanonical: Payload is of type: " + message.getPayload().getClass());
		
		CustomerServiceCreateResponse resp = (CustomerServiceCreateResponse) message.getPayload();
		
		EntityKeyList entityKeyList = resp.getEntityKeyList();
		
		// to iterate through the list
		Iterator<EntityKey> entityKeyListIterator = entityKeyList.getEntityKey().listIterator();
		
		System.out.println("\n Got a CustomerStore Response List of size = " + entityKeyList.getEntityKey().size());
		
        PartnerProfile canonPartnerProfile = (PartnerProfile) message.getProperty("canon", PropertyScope.SESSION);
        int idx=0;
        EntityKey entKey=null;
        
        while (entityKeyListIterator.hasNext()) {	
        	
        	entKey = entityKeyListIterator.next();
        	
        	canonPartnerProfile.getCompany().getCpDivision().get(0).getStores().get(idx).setAccountNum(entKey.getKeyData().getKeyField().get(0).getValue());
        	canonPartnerProfile.getCompany().getCpDivision().get(0).getStores().get(idx).setBhnCompanyCode(entKey.getKeyData().getKeyField().get(1).getValue());
        	canonPartnerProfile.getCompany().getCpDivision().get(0).getStores().get(idx).setBhnDivisionCode(entKey.getKeyData().getKeyField().get(2).getValue());
        	canonPartnerProfile.getCompany().getCpDivision().get(0).getStores().get(idx).setBhnGUID(entKey.getKeyData().getKeyField().get(3).getValue());

        	// TODO: put this logger pattern elsewhere
    		// logging accountNum & bhnGUID
    		System.out.println("accountNum=" + canonPartnerProfile.getCompany().getCpDivision().get(0).getStores().get(idx).getAccountNum() + " and bhnGUID=" + canonPartnerProfile.getCompany().getCpDivision().get(0).getStores().get(idx).getBhnGUID());

    		idx++;
        	entKey=null;
        }
        // update the canonical in session after enrichment
		message.setProperty("canon", canonPartnerProfile, PropertyScope.SESSION);
		
		return null;	// payload is no longer used in the flow past this transformer
	}
}