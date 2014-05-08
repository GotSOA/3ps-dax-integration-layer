package com.bhnetwork.integration.pppstodax.canonical;

import java.util.List;

/**
 * 
 * BHN Integration canonical model for Division
 * per spec 3.3, doc ref: MasterDataGapAnalysisGROUP 3PS v 3_3 .xlsx 
 * 
 * @author Stephane Rata - Got SOA?
 *
 */

public class Division {

	private	String	accountType;
	private	String	bhnGUID;
	private	String	bhnlocalpartner;
	private	String	bhnpartnerportalsource;
	private	String	companyCode;
	private	String	divisionCashierInstructions;
	private	String	divisionCode;
	private	String	divisionCustomerSupportContactFirstName;
	private	String	divisionCustomerSupportContactLastName;
	private	String	divisionCustomerSupportEmail;
	private	String	divisionCustomerSupportPhone;
	private	String	divisionCustomerSupportURL;
	private	String	divisionInStoreRedemptionInstructions;
	private	String	divisionIsPinRequiredForBI;
	private	String	divisionIsPinRequiredForRedemption;
	private	String	divisionLocale;
	private	String	divisionLogoURL;
	private	String	divisionOnlineRedemptionInstructions;
	private	String	divisionOnlineStoreURL;
	private	String	divisionProgramDescription;
	private	String	divisionRedemptionInformation;
	private	String	divisionRedemptionLine1;
	private	String	divisionRedemptionLine2;
	private	String	divisionRedemptionMethod;
	private	String	divisionRedemptionMethods;
	private	String	divisionTandCTextForPhysical;
	private	Boolean	isBhnSetupComplete;
	private	Boolean	isContractComplete;
	private	String	name;
	private	String	processorCode;
	private	String	processorContactFirstName;
	private	String	processorContactLastName;
	private	String	processorContactPhoneNumber;
	private	String	processorContactPhoneNumberExt;
	private	String	processorHasRealTimeIssuance;
	private	String	processorType;
	private	String	relationCode;
	
	// 1 or multiple products (UPCs)
	private List<Product> products;
	
	// somehow on the latest API 1.6 spec, the stores are part of division
	private List<Store> stores;
	
}