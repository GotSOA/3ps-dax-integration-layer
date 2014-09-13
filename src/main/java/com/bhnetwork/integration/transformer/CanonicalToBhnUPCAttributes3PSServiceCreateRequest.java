package com.bhnetwork.integration.transformer;

import java.math.BigDecimal;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.api.transport.PropertyScope;
import org.mule.transformer.AbstractMessageTransformer;

import com.bhnetwork.integration.pppstodax.canonical.Division;
import com.bhnetwork.integration.pppstodax.canonical.PartnerProfile;
import com.bhnetwork.integration.pppstodax.canonical.Product;
import com.microsoft.schemas.dynamics._2008._01.documents.bhnupcattributes3ps.AxdEntityBhnUPCAttr1;
import com.microsoft.schemas.dynamics._2008._01.documents.bhnupcattributes3ps.AxdEntityBhnUPCAttr2;
import com.microsoft.schemas.dynamics._2008._01.documents.bhnupcattributes3ps.AxdEntityInventTable;
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
		
		Division division = ((PartnerProfile) message.getPayload()).getCompany().getCpDivision().get(0);
		int idx=0;
		PartnerProfile canonPartnerProfile;
		
		for(Product product: division.getProducts()) {		

			if (idx < division.getProducts().size()-1) {
				// get some of the props from canonical (in session): companyCode, divisionCode, substGroupId
				canonPartnerProfile = (PartnerProfile) message.getProperty("canon", PropertyScope.SESSION);
				
				AxdEntityInventTable inventTable = new AxdEntityInventTable();
				// FIX (by Stephane): get companyCode not from product level but from company object (somehow 3PS doesn't pass it)
				//inventTable.setBhnCompany(product.getCompanyCode());
				inventTable.setBhnCompany(canonPartnerProfile.getCompany().getCompanyCode());
				
				// FIX (by Stephane): get divisionCode not from product level but from cpDivision object (somehow 3PS doesn't pass it)
				// inventTable.setBhnDivision(product.getDivisionCode());
				inventTable.setBhnDivision(canonPartnerProfile.getCompany().getCpDivision().get(0).getDivisionCode());
				
				
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
				
				// FIX (by Stephane): get substitutionGroup not from product level but from substGroup object (somehow 3PS doesn't pass it)
				//inventTable.setBhnSubGroup(product.getProductSubstitutionGroup());
				inventTable.setBhnSubGroup(canonPartnerProfile.getCompany().getCpDivision().get(0).getProducts().get(0).getSubstGrp().getSubGroupId());
				// the canon has been enriched by the substGroup web svc response in 3ps-dax-integration.xml line 224
				
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
			    
			    // System.out.println("ProductMaximumFaceValue: " + product.getProductMaximumFaceValue());
			    // System.out.println("ProductMinimumFaceValue: " + product.getProductMinimumFaceValue());
			    
			    bhnUPCAttr1.setBhnVariableMax(product.getProductMaximumFaceValue().intValue());
			    bhnUPCAttr1.setBhnVariableMin(product.getProductMinimumFaceValue().intValue());
			    
			    bhnUPCAttr1.setItemId("DEFAULT");
			    bhnUPCAttr1.setMulticardIndicator(product.getProductMultiCardIndicator().toString());    // DAX expecting String. 
			    bhnUPCAttr1.setReasonCode(product.getProductNewUPCReason());
			    // valid values are: NonOwned, OwnedShip or OwnedAct
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
				System.out.println("ProductTypeId: " + product.getProductTypeId());
			    bhnUPCAttr2.setProductTypeID(product.getProductTypeId());
			    bhnUPCAttr2.setReloadMaxAmount(new BigDecimal(product.getReloadMaxAmount()));
			    bhnUPCAttr2.setReloadMinAmount(new BigDecimal(product.getReloadMinAmount()));	    
			    bhnUPCAttr2.setClazz("entity");
			    
				inventTable.getBhnUPCAttr1().add(bhnUPCAttr1);
				inventTable.getBhnUPCAttr2().add(bhnUPCAttr2);
				bhnUPCAttributes3PS.getInventTable().add(inventTable);
				
				canonPartnerProfile=null;
			}
			else
				System.out.println("skipping final product (zombie element generated by DM)");
			
			idx++;	
		}
		req.setBhnUPCAttributes3PS(bhnUPCAttributes3PS);
		return req;
	}
}
