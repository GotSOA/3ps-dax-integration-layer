package com.bhnetwork.integration.pppstodax.canonical;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * BHN Integration canonical model for Product/Upc
 * per spec 3.3, doc ref: MasterDataGapAnalysisGROUP 3PS v 3_3 .xlsx 
 * 
 * @author Stephane Rata - Got SOA?
 *
 */

public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	private String	bhnGUID;
	private Boolean	bhnIsEANUPC;
	private String	companyCode;
	private String	customTemplatePathURL;
	private String	divisionCode;
	private Boolean	isActivationRequired;
	private Boolean	isProductDenominationVariable;
	private Boolean	isReloadable;
	private String	processorCode;
	private String	productAccountInquiryBIN;
	private String	productAccountTopupBIN;
	private String	productActivationInstructions;
	private String	productBackCardTemplateId;
	private String	productBHNNotes;
	private String	productBINForDARTransaction;
	private String	productBuyerGroup;
	private String	productChannelDimension;
	private Boolean	productIsCheckMinMax;
	private String	productClassification;
	private String	productCurrency;
	private String	productDefaultIID;
	private String	productDenomination;
	private String	productDimensionCode;
	private String	productDimensionGroup;
	private Date	productExpDate;
	private Integer	productExpLength;
	private String	productGroup;
	private String	productInventorySource;
	private String	productIssuerCompanyCode;
	private Boolean	productIsTaxable;
	private String	productItemGroupId;
	private String	productItemName;
	private Double	productMaximumFaceValue;
	private Double	productMinimumFaceValue;
	private String	productModelGroupId;
	// TODO change to String (default is 'N')
	private Boolean	productMultiCardIndicator;
	private String	productNewUPCReason;
	private String	productOwnershipType;
	private String	productSubstitutionGroup;
	private Boolean	productTaxIncluded;
	private String	productTermsAndConditions;
	private String	productType;
	private String	productTypeId;
	private Boolean	productIsUsingStandardDesign;
	private Double	reloadMaxAmount;
	private Double	reloadMinAmount;

	// we expect 1 IID per product
	private ItemID iid;

	private SubstitutionGroup substGrp;

	public String getBhnGUID() {
		return bhnGUID;
	}

	public void setBhnGUID(String bhnGUID) {
		this.bhnGUID = bhnGUID;
	}

	public Boolean getBhnIsEANUPC() {
		return bhnIsEANUPC;
	}

	public void setBhnIsEANUPC(Boolean bhnIsEANUPC) {
		this.bhnIsEANUPC = bhnIsEANUPC;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getCustomTemplatePathURL() {
		return customTemplatePathURL;
	}

	public void setCustomTemplatePathURL(String customTemplatePathURL) {
		this.customTemplatePathURL = customTemplatePathURL;
	}

	public String getDivisionCode() {
		return divisionCode;
	}

	public void setDivisionCode(String divisionCode) {
		this.divisionCode = divisionCode;
	}

	public Boolean getIsActivationRequired() {
		return isActivationRequired;
	}

	public void setIsActivationRequired(Boolean isActivationRequired) {
		this.isActivationRequired = isActivationRequired;
	}

	public Boolean getIsProductDenominationVariable() {
		return isProductDenominationVariable;
	}

	public void setIsProductDenominationVariable(
			Boolean isProductDenominationVariable) {
		this.isProductDenominationVariable = isProductDenominationVariable;
	}

	public Boolean getIsReloadable() {
		return isReloadable;
	}

	public void setIsReloadable(Boolean isReloadable) {
		this.isReloadable = isReloadable;
	}

	public String getProcessorCode() {
		return processorCode;
	}

	public void setProcessorCode(String processorCode) {
		this.processorCode = processorCode;
	}

	public String getProductAccountInquiryBIN() {
		return productAccountInquiryBIN;
	}

	public void setProductAccountInquiryBIN(String productAccountInquiryBIN) {
		this.productAccountInquiryBIN = productAccountInquiryBIN;
	}

	public String getProductAccountTopupBIN() {
		return productAccountTopupBIN;
	}

	public void setProductAccountTopupBIN(String productAccountTopupBIN) {
		this.productAccountTopupBIN = productAccountTopupBIN;
	}

	public String getProductActivationInstructions() {
		return productActivationInstructions;
	}

	public void setProductActivationInstructions(
			String productActivationInstructions) {
		this.productActivationInstructions = productActivationInstructions;
	}

	public String getProductBackCardTemplateId() {
		return productBackCardTemplateId;
	}

	public void setProductBackCardTemplateId(String productBackCardTemplateId) {
		this.productBackCardTemplateId = productBackCardTemplateId;
	}

	public String getProductBHNNotes() {
		return productBHNNotes;
	}

	public void setProductBHNNotes(String productBHNNotes) {
		this.productBHNNotes = productBHNNotes;
	}

	public String getProductBINForDARTransaction() {
		return productBINForDARTransaction;
	}

	public void setProductBINForDARTransaction(String productBINForDARTransaction) {
		this.productBINForDARTransaction = productBINForDARTransaction;
	}

	public String getProductBuyerGroup() {
		return productBuyerGroup;
	}

	public void setProductBuyerGroup(String productBuyerGroup) {
		this.productBuyerGroup = productBuyerGroup;
	}

	public String getProductChannelDimension() {
		return productChannelDimension;
	}

	public void setProductChannelDimension(String productChannelDimension) {
		this.productChannelDimension = productChannelDimension;
	}

	public Boolean getProductIsCheckMinMax() {
		return productIsCheckMinMax;
	}

	public void setProductIsCheckMinMax(Boolean productIsCheckMinMax) {
		this.productIsCheckMinMax = productIsCheckMinMax;
	}

	public String getProductClassification() {
		return productClassification;
	}

	public void setProductClassification(String productClassification) {
		this.productClassification = productClassification;
	}

	public String getProductCurrency() {
		return productCurrency;
	}

	public void setProductCurrency(String productCurrency) {
		this.productCurrency = productCurrency;
	}

	public String getProductDefaultIID() {
		return productDefaultIID;
	}

	public void setProductDefaultIID(String productDefaultIID) {
		this.productDefaultIID = productDefaultIID;
	}

	public String getProductDenomination() {
		return productDenomination;
	}

	public void setProductDenomination(String productDenomination) {
		this.productDenomination = productDenomination;
	}

	public String getProductDimensionCode() {
		return productDimensionCode;
	}

	public void setProductDimensionCode(String productDimensionCode) {
		this.productDimensionCode = productDimensionCode;
	}

	public String getProductDimensionGroup() {
		return productDimensionGroup;
	}

	public void setProductDimensionGroup(String productDimensionGroup) {
		this.productDimensionGroup = productDimensionGroup;
	}

	public Date getProductExpDate() {
		return productExpDate;
	}

	public void setProductExpDate(Date productExpDate) {
		this.productExpDate = productExpDate;
	}

	public Integer getProductExpLength() {
		return productExpLength;
	}

	public void setProductExpLength(Integer productExpLength) {
		this.productExpLength = productExpLength;
	}

	public String getProductGroup() {
		return productGroup;
	}

	public void setProductGroup(String productGroup) {
		this.productGroup = productGroup;
	}

	public String getProductInventorySource() {
		return productInventorySource;
	}

	public void setProductInventorySource(String productInventorySource) {
		this.productInventorySource = productInventorySource;
	}

	public String getProductIssuerCompanyCode() {
		return productIssuerCompanyCode;
	}

	public void setProductIssuerCompanyCode(String productIssuerCompanyCode) {
		this.productIssuerCompanyCode = productIssuerCompanyCode;
	}

	public Boolean getProductIsTaxable() {
		return productIsTaxable;
	}

	public void setProductIsTaxable(Boolean productIsTaxable) {
		this.productIsTaxable = productIsTaxable;
	}

	public String getProductItemGroupId() {
		return productItemGroupId;
	}

	public void setProductItemGroupId(String productItemGroupId) {
		this.productItemGroupId = productItemGroupId;
	}

	public String getProductItemName() {
		return productItemName;
	}

	public void setProductItemName(String productItemName) {
		this.productItemName = productItemName;
	}

	public Double getProductMaximumFaceValue() {
		return productMaximumFaceValue;
	}

	public void setProductMaximumFaceValue(Double productMaximumFaceValue) {
		this.productMaximumFaceValue = productMaximumFaceValue;
	}

	public Double getProductMinimumFaceValue() {
		return productMinimumFaceValue;
	}

	public void setProductMinimumFaceValue(Double productMinimumFaceValue) {
		this.productMinimumFaceValue = productMinimumFaceValue;
	}

	public String getProductModelGroupId() {
		return productModelGroupId;
	}

	public void setProductModelGroupId(String productModelGroupId) {
		this.productModelGroupId = productModelGroupId;
	}

	// TODO change to String
	public Boolean getProductMultiCardIndicator() {
		return productMultiCardIndicator;
	}

	public void setProductMultiCardIndicator(Boolean productMultiCardIndicator) {
		this.productMultiCardIndicator = productMultiCardIndicator;
	}

	public String getProductNewUPCReason() {
		return productNewUPCReason;
	}

	public void setProductNewUPCReason(String productNewUPCReason) {
		this.productNewUPCReason = productNewUPCReason;
	}

	public String getProductOwnershipType() {
		return productOwnershipType;
	}

	public void setProductOwnershipType(String productOwnershipType) {
		this.productOwnershipType = productOwnershipType;
	}

	public String getProductSubstitutionGroup() {
		return productSubstitutionGroup;
	}

	public void setProductSubstitutionGroup(String productSubstitutionGroup) {
		this.productSubstitutionGroup = productSubstitutionGroup;
	}

	public Boolean getProductTaxIncluded() {
		return productTaxIncluded;
	}

	public void setProductTaxIncluded(Boolean productTaxIncluded) {
		this.productTaxIncluded = productTaxIncluded;
	}

	public String getProductTermsAndConditions() {
		return productTermsAndConditions;
	}

	public void setProductTermsAndConditions(String productTermsAndConditions) {
		this.productTermsAndConditions = productTermsAndConditions;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(String productTypeId) {
		this.productTypeId = productTypeId;
	}

	public Boolean getProductIsUsingStandardDesign() {
		return productIsUsingStandardDesign;
	}

	public void setProductIsUsingStandardDesign(Boolean productIsUsingStandardDesign) {
		this.productIsUsingStandardDesign = productIsUsingStandardDesign;
	}

	public Double getReloadMaxAmount() {
		return reloadMaxAmount;
	}

	public void setReloadMaxAmount(Double reloadMaxAmount) {
		this.reloadMaxAmount = reloadMaxAmount;
	}

	public Double getReloadMinAmount() {
		return reloadMinAmount;
	}

	public void setReloadMinAmount(Double reloadMinAmount) {
		this.reloadMinAmount = reloadMinAmount;
	}

	public ItemID getIid() {
		return iid;
	}

	public void setIid(ItemID iid) {
		this.iid = iid;
	}

	public SubstitutionGroup getSubstGrp() {
		return substGrp;
	}

	public void setSubstGrp(SubstitutionGroup substGrp) {
		this.substGrp = substGrp;
	}


}