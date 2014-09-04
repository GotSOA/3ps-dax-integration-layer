package com.bhnetwork.integration.transformer;

import java.math.BigDecimal;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.api.transport.PropertyScope;
import org.mule.transformer.AbstractMessageTransformer;

import com.bhnetwork.integration.pppstodax.canonical.PartnerProfile;
import com.bhnetwork.integration.pppstodax.canonical.Product;
import com.microsoft.schemas.dynamics._2008._01.documents.bhnupcattributes3ps.AxdEntityBhnUPCAttr1;
import com.microsoft.schemas.dynamics._2008._01.documents.bhnupcattributes3ps.AxdEntityBhnUPCAttr2;
import com.microsoft.schemas.dynamics._2008._01.documents.bhnupcattributes3ps.AxdEntityInventTable;
import com.microsoft.schemas.dynamics._2008._01.documents.bhnupcattributes3ps.AxdEnumABC;
import com.microsoft.schemas.dynamics._2008._01.documents.bhnupcattributes3ps.AxdEnumNoYes;
import com.microsoft.schemas.dynamics._2008._01.documents.bhnupcattributes3ps.AxdExtTypeBhnUPCOwnershipType;
import com.microsoft.schemas.dynamics._2008._01.documents.bhnupcattributes3ps.AxdExtTypeNoYesId;
import com.microsoft.schemas.dynamics._2008._01.documents.bhnupcattributes3ps.AxdbhnUPCAttributes3PS;
import com.microsoft.schemas.dynamics._2008._01.services.BhnUPCAttributes3PSServiceCreateRequest;

public class CanonicalToBhnUPCAttributes3PSServiceCreateRequest extends
		AbstractMessageTransformer {

	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding)
			throws TransformerException {
		
		BhnUPCAttributes3PSServiceCreateRequest req = new BhnUPCAttributes3PSServiceCreateRequest();
		
		AxdbhnUPCAttributes3PS bhnUPCAttributes3PS = new AxdbhnUPCAttributes3PS(); 
		
		for(Product product: ((PartnerProfile) message.getPayload()).getCompany().getCpDivision().get(0).getProducts()){		
			AxdEntityInventTable inventTable = new AxdEntityInventTable();
			inventTable.setBhnCompany(product.getCompanyCode());
			inventTable.setBhnDivision(product.getDivisionCode());
			inventTable.setBhnNotes(product.getProductBHNNotes());
			inventTable.setItemGroupId(product.getProductItemGroupId());
			//TODO
			/*AxdArrayAxdExtTypeDimension axdArrayAxdExtTypeDimension = new AxdArrayAxdExtTypeDimension();
			axdArrayAxdExtTypeDimension.getElement().add(product.getProductChannelDimension());//TODO Have to double check how to exactly set. 
			inventTable.setDimension(axdArrayAxdExtTypeDimension);*/
			inventTable.setDimGroupId(product.getProductDimensionGroup());
			inventTable.setItemGroupId(product.getProductItemGroupId());
			inventTable.setItemName(product.getProductItemName());
			inventTable.setModelGroupId(product.getProductModelGroupId());
			inventTable.setBhnSubGroup(product.getProductSubstitutionGroup());
			inventTable.setPartnerProfileId(message.getProperty("partnerProfileId", PropertyScope.SESSION).toString());
			inventTable.setClazz("entity");
			
			
		    AxdEntityBhnUPCAttr1 bhnUPCAttr1 = new AxdEntityBhnUPCAttr1();
		    if(product.getIsProductDenominationVariable()!=null){
		    	bhnUPCAttr1.setVariableIndicator(product.getIsProductDenominationVariable()?AxdEnumNoYes.YES : AxdEnumNoYes.NO);
		    }
		    bhnUPCAttr1.setProductClass(product.getProductClassification());
		    bhnUPCAttr1.setCurrency(product.getProductCurrency());
		    //bhnUPCAttr1.setDenomination(product.getProductDenomination()); TODO Sample value, DAX expecting decimal.
		    bhnUPCAttr1.setProductGroup(product.getProductGroup());
		    if(product.getProductIsCheckMinMax()!=null){
		    	bhnUPCAttr1.setCheckMinMax(product.getProductIsCheckMinMax()?AxdEnumNoYes.YES : AxdEnumNoYes.NO);
		    }
		    bhnUPCAttr1.setIssuerCompanyCode(product.getProductIssuerCompanyCode());
		    bhnUPCAttr1.setBhnVariableMax(product.getProductMaximumFaceValue().intValue());//TODO Have to check why it was double in Canon (may be due to DM mapping)
		    bhnUPCAttr1.setBhnVariableMin(product.getProductMinimumFaceValue().intValue());//TODO Have to check why it was double in Canon (may be due to DM mapping)
		    bhnUPCAttr1.setItemId("DEFAULT");
		    //bhnUPCAttr1.setMulticardIndicator(product.getProductMultiCardIndicator());TODO DAX expecting String. 
		    bhnUPCAttr1.setReasonCode(product.getProductNewUPCReason());
		    bhnUPCAttr1.setOwnershipType(AxdExtTypeBhnUPCOwnershipType.fromValue(product.getProductOwnershipType()));
		    if(product.getProductTaxIncluded()!=null){
		    	bhnUPCAttr1.setTaxIncluded(product.getProductTaxIncluded()? AxdExtTypeNoYesId.YES : AxdExtTypeNoYesId.NO);
		    }
		    bhnUPCAttr1.setProductType(product.getProductType());
		    bhnUPCAttr1.setClazz("entity");
		    
		    AxdEntityBhnUPCAttr2 bhnUPCAttr2 = new AxdEntityBhnUPCAttr2();
			bhnUPCAttr2.setCustomtemplatepathURL(product.getCustomTemplatePathURL());//TODO Source of Origin seems to be DAX on the mapping document.
			if(product.getIsActivationRequired()!=null){
				bhnUPCAttr2.setProductIsActivationRequired(product.getIsActivationRequired()?AxdEnumNoYes.YES : AxdEnumNoYes.NO);
			}
			if(product.getIsReloadable()!=null){
				bhnUPCAttr2.setProductIsReloadable(product.getIsReloadable()?AxdEnumNoYes.YES : AxdEnumNoYes.NO);
			}
		    bhnUPCAttr2.setProductTypeID(product.getProductTypeId());
		    bhnUPCAttr2.setReloadMaxAmount(new BigDecimal(product.getReloadMaxAmount()));
		    bhnUPCAttr2.setReloadMinAmount(new BigDecimal(product.getReloadMinAmount()));	    
		    bhnUPCAttr2.setClazz("entity");
		    
			inventTable.getBhnUPCAttr1().add(bhnUPCAttr1);
			inventTable.getBhnUPCAttr2().add(bhnUPCAttr2);
			bhnUPCAttributes3PS.getInventTable().add(inventTable);
		}
		req.setBhnUPCAttributes3PS(bhnUPCAttributes3PS);
		return req;
	}
}
