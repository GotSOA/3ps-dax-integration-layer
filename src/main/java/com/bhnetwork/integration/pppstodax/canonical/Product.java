package com.bhnetwork.integration.pppstodax.canonical;

import java.util.Date;

/**
 * 
 * BHN Integration canonical model for Product/Upc
 * per spec 3.3, doc ref: MasterDataGapAnalysisGROUP 3PS v 3_3 .xlsx 
 * 
 * @author Stephane Rata - Got SOA?
 *
 */

public class Product {
	
	private String	bhnBarcodeType;
	private String	bhnCheckDigit;
	private Boolean	bhnComplete;
	private String	bhnGUID;
	private Boolean	bhnIsEANUPC;
	private Date	bhnSetupCompleteDate;
	private String	bhnSetupCompletedBy;
	private String	bhnStatus;
	private String	companyCode;
	private String	customTemplatePathURL;
	private String	divisionCode;
	private Boolean	isActivationRequired;
	private Boolean	isProductDenominationVariable;
	private Boolean	isReloadable;
	private String	ItemId;
	private String	ItemPriceToleranceGroupId;
	private String	ItemType;
	private Boolean	isSearchText;
	private String	NameAlias;
	private String	processorCode;
	private String	ProcessorType;
	private String	productAccountInquiryBIN;
	private String	productAccountTopupBIN;
	private String	productActivationInstructions;
	private String	productBackCardTemplateId;
	private String	productBHNNotes;
	private String	productBINForDARTransaction;
	private String	productBuyerGroup;
	private String	productChannelDimension;
	private Boolean	isProductCheckMinMax;
	private String	productClass;
	private String	productCurrency;
	private String	productDefaultId;
	private String	productDenomination;
	private String	productDimensionCode;
	private String	productDimensionGroup;
	private Date	productExpDate;
	private Integer	productExpLength;
	private String	productGroup;
	private String	productInventorySourceId;
	private String	productIssuerCompanyCode;
	private Boolean	isProductTaxable;
	private String	productItemGroupId;
	private String	productItemName;
	private Double	productMaximumFaceValue;
	private Double	productMinimumFaceValue;
	private String	productModelGroupId;
	private Boolean	IsProductMultiCardIndicator;
	private String	productNewUPCReason;
	private String	productOwnershipType;
	private String	productSubstitutionGroup;
	private Boolean	IsProductTaxIncluded;
	private String	productTermsAndConditions;
	private String	productType;
	private String	productTypeId;
	private Boolean	isProductUsingStandardDesignTemplate;
	private Double	reloadMaxAmount;
	private Double	reloadMinAmount;
	
	// we expect 1 IID per product
	private ItemID iid;
	
	private SubstitutionGroup substGrp;
	
}