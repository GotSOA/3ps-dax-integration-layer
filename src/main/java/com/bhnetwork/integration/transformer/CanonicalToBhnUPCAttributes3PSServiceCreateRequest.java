package com.bhnetwork.integration.transformer;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;

import com.bhnetwork.integration.pppstodax.canonical.PartnerProfile;
import com.bhnetwork.integration.pppstodax.canonical.Product;
import com.microsoft.schemas.dynamics._2008._01.documents.bhnupcattributes3ps.AxdEntityBhnUPCAttr1;
import com.microsoft.schemas.dynamics._2008._01.documents.bhnupcattributes3ps.AxdEntityBhnUPCAttr2;
import com.microsoft.schemas.dynamics._2008._01.documents.bhnupcattributes3ps.AxdEntityInventTable;
import com.microsoft.schemas.dynamics._2008._01.documents.bhnupcattributes3ps.AxdEnumNoYes;
import com.microsoft.schemas.dynamics._2008._01.documents.bhnupcattributes3ps.AxdbhnUPCAttributes3PS;
import com.microsoft.schemas.dynamics._2008._01.services.BhnUPCAttributes3PSServiceCreateRequest;

public class CanonicalToBhnUPCAttributes3PSServiceCreateRequest extends
		AbstractMessageTransformer {

	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding)
			throws TransformerException {
		
		Product product = ((PartnerProfile) message.getPayload()).getCompany().getCpDivision().get(0).getProducts().get(0);
		BhnUPCAttributes3PSServiceCreateRequest req = new BhnUPCAttributes3PSServiceCreateRequest();
		
		AxdbhnUPCAttributes3PS bhnUPCAttributes3PS = new AxdbhnUPCAttributes3PS(); 
		
		AxdEntityInventTable inventTable = new AxdEntityInventTable();
		inventTable.setBhnCompany(product.getCompanyCode());
		inventTable.setBhnDivision(product.getDivisionCode());
		
	    AxdEntityBhnUPCAttr1 bhnUPCAttr1 = new AxdEntityBhnUPCAttr1();
	    bhnUPCAttr1.setVariableIndicator(product.getIsProductDenominationVariable()?AxdEnumNoYes.YES : AxdEnumNoYes.NO);
	    
	    AxdEntityBhnUPCAttr2 bhnUPCAttr2 = new AxdEntityBhnUPCAttr2();
		bhnUPCAttr2.setCustomtemplatepathURL(product.getCustomTemplatePathURL());//TODO Stephane Fix the mapping document
	    bhnUPCAttr2.setProductIsActivationRequired(product.getIsActivationRequired()?AxdEnumNoYes.YES : AxdEnumNoYes.NO);
		
		inventTable.getBhnUPCAttr1().add(bhnUPCAttr1);
		inventTable.getBhnUPCAttr2().add(bhnUPCAttr2);
		bhnUPCAttributes3PS.getInventTable().add(inventTable);
		req.setBhnUPCAttributes3PS(bhnUPCAttributes3PS);
		return req;
	}
}
