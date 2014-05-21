package com.bhnetwork.integration.transformer;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;
import org.tempuri.BhnIIDAttributesServiceCreateRequest;

import com.bhnetwork.integration.pppstodax.canonical.ItemID;
import com.bhnetwork.integration.pppstodax.canonical.PartnerProfile;
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
		
		ItemID iid = ((PartnerProfile) message.getPayload()).getCompany().getCpDivision().get(0).getProducts().get(0).getIid();	
		BhnIIDAttributesServiceCreateRequest req = new BhnIIDAttributesServiceCreateRequest();
		
		AxdBhnIIDAttributes bhnIIDAttributes = new AxdBhnIIDAttributes();
		
		AxdEntityInventBatch inventBatch = new AxdEntityInventBatch();
		inventBatch.setBhnNotes(null);//TODO In Spec but not in Canonical POJO and JSON
		inventBatch.setBhnDivDescription(iid.getDivisionBrandName());
		inventBatch.setBhnDivCode(iid.getDivisionCode());
		inventBatch.setDescription(iid.getIidDescription());
		//inventBatch.setExpDate(CalendarUtil.dateToXMLGregorianCalendar(iid.getIidExpiryDate);TODO In Spec but not in Canonical POJO and JSON	
		inventBatch.setClazz("entity");
	
		iid.getIidActivationType();
		
		AxdEntityBhnIIDAttributes entityBhnIIDAttributes = new AxdEntityBhnIIDAttributes();
		entityBhnIIDAttributes.setActivationType(AxdEnumBhnActivationType.fromValue(iid.getIidActivationType().toLowerCase()));
		entityBhnIIDAttributes.setCaseCount(iid.getIidCaseCount());
		entityBhnIIDAttributes.setPackSize(iid.getIidPackSize());
		entityBhnIIDAttributes.setCountry(iid.getIidCountry());
		entityBhnIIDAttributes.setLanguage(iid.getLanguage());
		entityBhnIIDAttributes.setNewIIDReasonCode(iid.getNewIidReasonCode());
		entityBhnIIDAttributes.setPackSize(iid.getIidPackSize());
		entityBhnIIDAttributes.setProdPackType(iid.getIidProdPackType());
		entityBhnIIDAttributes.setUseStdUnitConvert(iid.getIidUseStdUnitConvert() ? AxdExtTypeNoYesId.YES : AxdExtTypeNoYesId.NO);
		entityBhnIIDAttributes.setClazz("entity");
	    
		AxdEntityBhnOnlineIIDAttributes bhnOnlineIIDAttributes = new AxdEntityBhnOnlineIIDAttributes();
	    bhnOnlineIIDAttributes.setDivisionCardImageURL(iid.getDivisionCardImageURL());
	    bhnOnlineIIDAttributes.setGCMIIDDescription(iid.getIidDescription());
	    bhnOnlineIIDAttributes.setClazz("entity");
	    
	    inventBatch.getBhnIIDAttributes().add(entityBhnIIDAttributes);
	    inventBatch.getBhnOnlineIIDAttributes().add(bhnOnlineIIDAttributes);
	    bhnIIDAttributes.getInventBatch().add(inventBatch);
	    req.setBhnIIDAttributes(bhnIIDAttributes);
	    return req;
	}
}
