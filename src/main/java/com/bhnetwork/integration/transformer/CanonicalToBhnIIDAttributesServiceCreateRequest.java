package com.bhnetwork.integration.transformer;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.api.transport.PropertyScope;
import org.mule.transformer.AbstractMessageTransformer;
import org.tempuri.BhnIIDAttributesServiceCreateRequest;

import com.bhnetwork.integration.pppstodax.canonical.ItemID;
import com.bhnetwork.integration.pppstodax.canonical.PartnerProfile;
import com.bhnetwork.integration.pppstodax.canonical.Product;
import com.bhnetwork.integration.pppstodax.canonical.Division;
import com.microsoft.schemas.dynamics._2008._01.documents.bhniidattributes.AxdBhnIIDAttributes;
import com.microsoft.schemas.dynamics._2008._01.documents.bhniidattributes.AxdEntityBhnIIDAttributes;
import com.microsoft.schemas.dynamics._2008._01.documents.bhniidattributes.AxdEntityBhnOnlineIIDAttributes;
import com.microsoft.schemas.dynamics._2008._01.documents.bhniidattributes.AxdEntityInventBatch;
import com.microsoft.schemas.dynamics._2008._01.documents.bhniidattributes.AxdEnumBhnActivationType;
import com.microsoft.schemas.dynamics._2008._01.documents.bhniidattributes.AxdExtTypeNoYesId;

public class CanonicalToBhnIIDAttributesServiceCreateRequest extends
		AbstractMessageTransformer {

	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding)
			throws TransformerException {
		
		BhnIIDAttributesServiceCreateRequest req = new BhnIIDAttributesServiceCreateRequest();
		
		AxdBhnIIDAttributes bhnIIDAttributes = new AxdBhnIIDAttributes();
		int idx=0;
		ItemID iid=null;
		AxdEntityInventBatch inventBatch = null;
		
		Division division = ((PartnerProfile) message.getPayload()).getCompany().getCpDivision().get(0);
		PartnerProfile canonPartnerProfile = (PartnerProfile) message.getProperty("canon", PropertyScope.SESSION);
		
		for(Product product: division.getProducts()){
			
			iid = product.getIid();
			System.out.println("IID(" + idx + "): " + iid.toString());
			
			if (idx < division.getProducts().size() - 1) {
					
				inventBatch = new AxdEntityInventBatch();
				
				//TODO: In Spec but not in Canonical POJO and JSON: extend canonical
				inventBatch.setBhnNotes(null);
				
				// from canon
				inventBatch.setBhnDivCode(canonPartnerProfile.getCompany().getCpDivision().get(0).getDivisionCode());
				// TODO: In 3PS json, DivisionBrandName should not be at IID level but derived from Division entity
				// however the BrandName property needs extension of the current canonical
				//inventBatch.setBhnDivDescription(canonPartnerProfile.getCompany().getCpDivision().get(0).getDivisionBrandName());
				// using Division Name for now, and may be this is the correct approach.
				inventBatch.setBhnDivDescription(canonPartnerProfile.getCompany().getCpDivision().get(0).getName());
				inventBatch.setDescription(iid.getIidDescription());
				//inventBatch.setExpDate(CalendarUtil.dateToXMLGregorianCalendar(iid.getIidExpiryDate);  //TODO In Spec but not in Canonical POJO and JSON
				inventBatch.setInventBatchId("DEFAULT");
				
				// 
				inventBatch.setItemId(iid.getItemId());
				inventBatch.setPartnerProfileId(message.getProperty("partnerProfileId", PropertyScope.SESSION).toString());
				inventBatch.setClazz("entity");
				
				AxdEntityBhnIIDAttributes entityBhnIIDAttributes = new AxdEntityBhnIIDAttributes();
				entityBhnIIDAttributes.setActivationType(AxdEnumBhnActivationType.fromValue(iid.getIidActivationType().toLowerCase()));
				entityBhnIIDAttributes.setCaseCount(iid.getIidCaseCount());
				entityBhnIIDAttributes.setPackSize(iid.getIidPackSize());
				entityBhnIIDAttributes.setCountry(iid.getIidCountry());
				entityBhnIIDAttributes.setLanguage(iid.getLanguage());
				entityBhnIIDAttributes.setNewIIDReasonCode(iid.getNewIidReasonCode());
				entityBhnIIDAttributes.setPackSize(iid.getIidPackSize());
				
				// acceptable values for ProdPackType: BOXSOFTWAR, COCCDA, COCCRA, CR80REA, DPCRA, MLTCDA, MLTCRA, OTHER, PHBCA	
				entityBhnIIDAttributes.setProdPackType(iid.getIidProdPackType());
				if(iid.getIidUseStdUnitConvert()!=null){
					entityBhnIIDAttributes.setUseStdUnitConvert(iid.getIidUseStdUnitConvert() ? AxdExtTypeNoYesId.YES : AxdExtTypeNoYesId.NO);
				}
				entityBhnIIDAttributes.setInventBatchId("DEFAULT");				//TODO Hard coded
				entityBhnIIDAttributes.setItemId(iid.getItemId());
				entityBhnIIDAttributes.setClazz("entity");
			    
				AxdEntityBhnOnlineIIDAttributes bhnOnlineIIDAttributes = new AxdEntityBhnOnlineIIDAttributes();
			    bhnOnlineIIDAttributes.setDivisionCardImageURL(iid.getDivisionCardImageURL());
			    bhnOnlineIIDAttributes.setGCMIIDDescription(iid.getIidDescription());
			    bhnOnlineIIDAttributes.setInventBatchId("DEFAULT");				//TODO Hard coded
			    bhnOnlineIIDAttributes.setItemId(iid.getItemId());
			    bhnOnlineIIDAttributes.setClazz("entity");
			    
			    inventBatch.getBhnIIDAttributes().add(entityBhnIIDAttributes);
			    inventBatch.getBhnOnlineIIDAttributes().add(bhnOnlineIIDAttributes);
			    
			    bhnIIDAttributes.getInventBatch().add(inventBatch);
			    System.out.println("Adding IID(" + idx + ") to invent batch");
			    inventBatch=null;
			    iid=null;
			}
			else
				System.out.println("Skipping zombie IID...");
			
		    idx++;
		}
	    req.setBhnIIDAttributes(bhnIIDAttributes);
	    return req;
	}
}
