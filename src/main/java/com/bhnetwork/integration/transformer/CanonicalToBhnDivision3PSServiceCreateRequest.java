package com.bhnetwork.integration.transformer;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.api.transport.PropertyScope;
import org.mule.transformer.AbstractMessageTransformer;

import com.bhnetwork.integration.pppstodax.canonical.Division;
import com.bhnetwork.integration.pppstodax.canonical.PartnerProfile;
import com.microsoft.schemas.dynamics._2008._01.documents.bhndivision3ps.AxdEntityBhnCustDivisionTable;
import com.microsoft.schemas.dynamics._2008._01.documents.bhndivision3ps.AxdEntityBhnDivisionAttributes;
import com.microsoft.schemas.dynamics._2008._01.documents.bhndivision3ps.AxdEnumDivisionAccountType;
import com.microsoft.schemas.dynamics._2008._01.documents.bhndivision3ps.AxdEnumNoYes;
import com.microsoft.schemas.dynamics._2008._01.documents.bhndivision3ps.AxdbhnDivision3PS;
import com.microsoft.schemas.dynamics._2008._01.services.BhnDivision3PSServiceCreateRequest;

public class CanonicalToBhnDivision3PSServiceCreateRequest extends
		AbstractMessageTransformer {

	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding)
			throws TransformerException {
		Division division = ((PartnerProfile) message.getPayload()).getCompany().getCpDivision().get(0);
		BhnDivision3PSServiceCreateRequest req = new BhnDivision3PSServiceCreateRequest();
		
		AxdbhnDivision3PS bhnDivision3PS = new AxdbhnDivision3PS();
		
		AxdEntityBhnCustDivisionTable bhnCustDivisionTable = new AxdEntityBhnCustDivisionTable();
		//bhnCustDivisionTable.setName("TODO"); TODO In JSON inside vendor as divisionBrandName
		bhnCustDivisionTable.setContractComplete(division.getDivisionIsContractComplete()? AxdEnumNoYes.YES : AxdEnumNoYes.NO);
		bhnCustDivisionTable.setCompanyCode(division.getCompanyCode());
		//bhnCustDivisionTable.setBhnLocalPartner(division.getDivisionLocalPartner()? AxdEnumNoYes.YES : AxdEnumNoYes.NO); TODO
		bhnCustDivisionTable.setBhnPartnerPortalSource(division.getDivisionLocalPartnerSource());
		bhnCustDivisionTable.setDivisionCode(division.getDivisionCode());
		bhnCustDivisionTable.setName("DEFAULT");//TODO
		bhnCustDivisionTable.setPartnerProfileId(message.getProperty("partnerProfileId", PropertyScope.SESSION).toString());
		bhnCustDivisionTable.setProcessorCode(division.getDivisionProcessorCode());
		bhnCustDivisionTable.setRelationCode("CP");//TODO defaulted value taken from spec for now.		
		bhnCustDivisionTable.setClazz("entity");
		
		AxdEntityBhnDivisionAttributes bhnDivisionAttributes = new AxdEntityBhnDivisionAttributes();
		bhnDivisionAttributes.setDivisionAccountType(AxdEnumDivisionAccountType.NONE);//TODO Possible values CREDIT_CARD, GIFT_CARD, PHONE_CARD, LOYALTY_CARD
		bhnDivisionAttributes.setDivisionCashierInstructions(division.getDivisionCashierInstructions());
		bhnDivisionAttributes.setDivisionCode(division.getDivisionCode());
		bhnDivisionAttributes.setDivisionCustomerSupportContactFirstN(division.getDivisionCustomerSupportContactFirstName());
		bhnDivisionAttributes.setDivisionCustomerSupportContactLastNa(division.getDivisionCustomerSupportContactLastName());
		bhnDivisionAttributes.setDivisionCustomerSupportEmail(division.getDivisionCustomerSupportEmail());
		bhnDivisionAttributes.setDivisionCustomerSupportPhone(division.getDivisionCustomerSupportPhone());
		bhnDivisionAttributes.setDivisionCustomerSupportURL(division.getDivisionCustomerSupportURL());
		bhnDivisionAttributes.setDivisionInStoreRedemptionInstruction(division.getDivisionInStoreRedemptionInstructions());
		bhnDivisionAttributes.setDivisionIsPinRequiredForBI(AxdEnumNoYes.fromValue(division.getDivisionIsPinRequiredForBI()));
		bhnDivisionAttributes.setDivisionIsPinRequiredForRedemption(AxdEnumNoYes.fromValue(division.getDivisionIsPinRequiredForRedemption()));
		//bhnDivisionAttributes.setDivisionLocale(AxdEnumDivisionLocale.fromValue(division.getDivisionLocale()));TODO Only None is defined in the ENUM
		bhnDivisionAttributes.setDivisionLogoURL(division.getDivisionLogoURL());
		bhnDivisionAttributes.setDivisionOnlineRedemptionInstructions(division.getDivisionOnlineRedemptionInstructions());
		bhnDivisionAttributes.setDivisionOnlineStoreURL(division.getDivisionOnlineStoreURL());
		bhnDivisionAttributes.setDivisionProgramDescription(division.getDivisionProgramDescription());
		bhnDivisionAttributes.setDivisionRedemptionInformation(division.getDivisionRedemptionInformation());
		bhnDivisionAttributes.setDivisionRedemptionLine1(division.getDivisionRedemptionLine1());
		bhnDivisionAttributes.setDivisionRedemptionLine2(division.getDivisionRedemptionLine2());
		//TODO divisionRedemptionLocationType
		//TODO divisionRedemptionMethods
		bhnDivisionAttributes.setDivisionTandCTextForPhysical(division.getDivisionTandCTextForPhysical());
		bhnDivisionAttributes.setClazz("entity");
		
		bhnCustDivisionTable.getBhnDivisionAttributes().add(bhnDivisionAttributes);
		bhnDivision3PS.getBhnCustDivisionTable().add(bhnCustDivisionTable);
		req.setBhnDivision3PS(bhnDivision3PS);
		return req;
	}
}
