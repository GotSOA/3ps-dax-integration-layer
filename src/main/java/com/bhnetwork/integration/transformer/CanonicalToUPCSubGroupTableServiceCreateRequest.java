package com.bhnetwork.integration.transformer;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.api.transport.PropertyScope;
import org.mule.transformer.AbstractMessageTransformer;
import org.tempuri.UPCSubGroupTableServiceCreateRequest;

import com.bhnetwork.integration.pppstodax.canonical.Division;
import com.bhnetwork.integration.pppstodax.canonical.PartnerProfile;
import com.bhnetwork.integration.pppstodax.canonical.Product;
import com.bhnetwork.integration.pppstodax.canonical.SubstitutionGroup;
import com.microsoft.schemas.dynamics._2008._01.documents.upcsubgrouptable.AxdEntityBhnUPCSubGroupTable1;
import com.microsoft.schemas.dynamics._2008._01.documents.upcsubgrouptable.AxdEnumNoYes;
import com.microsoft.schemas.dynamics._2008._01.documents.upcsubgrouptable.AxdUPCSubGroupTable;

public class CanonicalToUPCSubGroupTableServiceCreateRequest extends
		AbstractMessageTransformer {

	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding)
			throws TransformerException {
		UPCSubGroupTableServiceCreateRequest req = new UPCSubGroupTableServiceCreateRequest();
		AxdUPCSubGroupTable upcSubGroupTable = new AxdUPCSubGroupTable();
		
		Division division = ((PartnerProfile) message.getPayload()).getCompany().getCpDivision().get(0);
		for(Product product: division.getProducts()) {
			SubstitutionGroup substitutionGroup = product.getSubstGrp();		
			AxdEntityBhnUPCSubGroupTable1 bhnUPCSubGroupTable1 = new AxdEntityBhnUPCSubGroupTable1();
			bhnUPCSubGroupTable1.setBhnDivisionCode(division.getDivisionCode());
			bhnUPCSubGroupTable1.setCardDisplayDesc(substitutionGroup.getSubstitutionCardDisplayDesc());
			bhnUPCSubGroupTable1.setName("DEFAULT");
			bhnUPCSubGroupTable1.setPartnerProfileId(message.getProperty("partnerProfileId", PropertyScope.SESSION).toString());
			bhnUPCSubGroupTable1.setPOGCategory1(substitutionGroup.getSubstitutionPOG1Category());
			bhnUPCSubGroupTable1.setPOGCategory2(substitutionGroup.getSubstitutionPOG2Category());
			bhnUPCSubGroupTable1.setPOGCategory3(substitutionGroup.getSubstitutionPOG3Category());
			bhnUPCSubGroupTable1.setPOGDimension(substitutionGroup.getSubstitutionPOGDimension());
			bhnUPCSubGroupTable1.setPortalDisplayName(substitutionGroup.getSubstitutionPortalDisplayName());
			bhnUPCSubGroupTable1.setShipperUPC(AxdEnumNoYes.NO);//TODO currently defaulted to NO as per spec. Will have to revisit it once we get JSON sample value.
			bhnUPCSubGroupTable1.setSubGroupId("DEFAULT");
			bhnUPCSubGroupTable1.setClazz("entity");
			
			upcSubGroupTable.getBhnUPCSubGroupTable1().add(bhnUPCSubGroupTable1);
		}
		req.setUPCSubGroupTable(upcSubGroupTable);
		return req;
	}
}
