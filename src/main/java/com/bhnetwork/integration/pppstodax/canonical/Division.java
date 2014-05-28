package com.bhnetwork.integration.pppstodax.canonical;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * BHN Integration canonical model for Division
 * per spec 3.3, doc ref: MasterDataGapAnalysisGROUP 3PS v 3_3 .xlsx 
 * 
 * @author Stephane Rata - Got SOA?
 *
 */

public class Division implements Serializable {
	private static final long serialVersionUID = 1L;

	private String accountType;
	private String bhnGUID;
	private Boolean divisionLocalPartner;
	private String divisionLocalPartnerSource;
	private String companyCode;
	private String divisionCashierInstructions;
	private String divisionCode;
	private String divisionCustomerSupportContactFirstName;
	private String divisionCustomerSupportContactLastName;
	private String divisionCustomerSupportEmail;
	private String divisionCustomerSupportPhone;
	private String divisionCustomerSupportURL;
	private String divisionInStoreRedemptionInstructions;
	private String divisionIsPinRequiredForBI;
	private String divisionIsPinRequiredForRedemption;
	private String divisionLocale;
	private String divisionLogoURL;
	private String divisionOnlineRedemptionInstructions;
	private String divisionOnlineStoreURL;
	private String divisionProcessorCode;
	private String divisionProgramDescription;
	private String divisionRedemptionInformation;
	private String divisionRedemptionLine1;
	private String divisionRedemptionLine2;
	private String divisionRedemptionMethods;
	private String divisionTandCTextForPhysical;
	private Boolean divisionIsContractComplete;
	private String name;
	private String processorCode;
	private String processorContactFirstName;
	private String processorContactLastName;
	private String processorContactPhoneNumber;
	private String processorContactPhoneNumberExt;
	private String processorHasRealTimeIssuance;

	// 1 or multiple products (UPCs)
	private List<Product> products;
	private String recId;

	// somehow on the latest API 1.6 spec, the stores are part of division
	private List<Store> stores;

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getBhnGUID() {
		return bhnGUID;
	}

	public void setBhnGUID(String bhnGUID) {
		this.bhnGUID = bhnGUID;
	}

	public Boolean getDivisionLocalPartner() {
		return divisionLocalPartner;
	}

	public void setDivisionLocalPartner(Boolean divisionLocalPartner) {
		this.divisionLocalPartner = divisionLocalPartner;
	}

	public String getDivisionLocalPartnerSource() {
		return divisionLocalPartnerSource;
	}

	public void setDivisionLocalPartnerSource(String divisionLocalPartnerSource) {
		this.divisionLocalPartnerSource = divisionLocalPartnerSource;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getDivisionCashierInstructions() {
		return divisionCashierInstructions;
	}

	public void setDivisionCashierInstructions(String divisionCashierInstructions) {
		this.divisionCashierInstructions = divisionCashierInstructions;
	}

	public String getDivisionCode() {
		return divisionCode;
	}

	public void setDivisionCode(String divisionCode) {
		this.divisionCode = divisionCode;
	}

	public String getDivisionCustomerSupportContactFirstName() {
		return divisionCustomerSupportContactFirstName;
	}

	public void setDivisionCustomerSupportContactFirstName(
			String divisionCustomerSupportContactFirstName) {
		this.divisionCustomerSupportContactFirstName = divisionCustomerSupportContactFirstName;
	}

	public String getDivisionCustomerSupportContactLastName() {
		return divisionCustomerSupportContactLastName;
	}

	public void setDivisionCustomerSupportContactLastName(
			String divisionCustomerSupportContactLastName) {
		this.divisionCustomerSupportContactLastName = divisionCustomerSupportContactLastName;
	}

	public String getDivisionCustomerSupportEmail() {
		return divisionCustomerSupportEmail;
	}

	public void setDivisionCustomerSupportEmail(String divisionCustomerSupportEmail) {
		this.divisionCustomerSupportEmail = divisionCustomerSupportEmail;
	}

	public String getDivisionCustomerSupportPhone() {
		return divisionCustomerSupportPhone;
	}

	public void setDivisionCustomerSupportPhone(String divisionCustomerSupportPhone) {
		this.divisionCustomerSupportPhone = divisionCustomerSupportPhone;
	}

	public String getDivisionCustomerSupportURL() {
		return divisionCustomerSupportURL;
	}

	public void setDivisionCustomerSupportURL(String divisionCustomerSupportURL) {
		this.divisionCustomerSupportURL = divisionCustomerSupportURL;
	}

	public String getDivisionInStoreRedemptionInstructions() {
		return divisionInStoreRedemptionInstructions;
	}

	public void setDivisionInStoreRedemptionInstructions(
			String divisionInStoreRedemptionInstructions) {
		this.divisionInStoreRedemptionInstructions = divisionInStoreRedemptionInstructions;
	}

	public String getDivisionIsPinRequiredForBI() {
		return divisionIsPinRequiredForBI;
	}

	public void setDivisionIsPinRequiredForBI(String divisionIsPinRequiredForBI) {
		this.divisionIsPinRequiredForBI = divisionIsPinRequiredForBI;
	}

	public String getDivisionIsPinRequiredForRedemption() {
		return divisionIsPinRequiredForRedemption;
	}

	public void setDivisionIsPinRequiredForRedemption(
			String divisionIsPinRequiredForRedemption) {
		this.divisionIsPinRequiredForRedemption = divisionIsPinRequiredForRedemption;
	}

	public String getDivisionLocale() {
		return divisionLocale;
	}

	public void setDivisionLocale(String divisionLocale) {
		this.divisionLocale = divisionLocale;
	}

	public String getDivisionLogoURL() {
		return divisionLogoURL;
	}

	public void setDivisionLogoURL(String divisionLogoURL) {
		this.divisionLogoURL = divisionLogoURL;
	}

	public String getDivisionOnlineRedemptionInstructions() {
		return divisionOnlineRedemptionInstructions;
	}

	public void setDivisionOnlineRedemptionInstructions(
			String divisionOnlineRedemptionInstructions) {
		this.divisionOnlineRedemptionInstructions = divisionOnlineRedemptionInstructions;
	}

	public String getDivisionOnlineStoreURL() {
		return divisionOnlineStoreURL;
	}

	public void setDivisionOnlineStoreURL(String divisionOnlineStoreURL) {
		this.divisionOnlineStoreURL = divisionOnlineStoreURL;
	}

	public String getDivisionProcessorCode() {
		return divisionProcessorCode;
	}

	public void setDivisionProcessorCode(String divisionProcessorCode) {
		this.divisionProcessorCode = divisionProcessorCode;
	}

	public String getDivisionProgramDescription() {
		return divisionProgramDescription;
	}

	public void setDivisionProgramDescription(String divisionProgramDescription) {
		this.divisionProgramDescription = divisionProgramDescription;
	}

	public String getDivisionRedemptionInformation() {
		return divisionRedemptionInformation;
	}

	public void setDivisionRedemptionInformation(
			String divisionRedemptionInformation) {
		this.divisionRedemptionInformation = divisionRedemptionInformation;
	}

	public String getDivisionRedemptionLine1() {
		return divisionRedemptionLine1;
	}

	public void setDivisionRedemptionLine1(String divisionRedemptionLine1) {
		this.divisionRedemptionLine1 = divisionRedemptionLine1;
	}

	public String getDivisionRedemptionLine2() {
		return divisionRedemptionLine2;
	}

	public void setDivisionRedemptionLine2(String divisionRedemptionLine2) {
		this.divisionRedemptionLine2 = divisionRedemptionLine2;
	}

	public String getDivisionRedemptionMethods() {
		return divisionRedemptionMethods;
	}

	public void setDivisionRedemptionMethods(String divisionRedemptionMethods) {
		this.divisionRedemptionMethods = divisionRedemptionMethods;
	}

	public String getDivisionTandCTextForPhysical() {
		return divisionTandCTextForPhysical;
	}

	public void setDivisionTandCTextForPhysical(String divisionTandCTextForPhysical) {
		this.divisionTandCTextForPhysical = divisionTandCTextForPhysical;
	}

	public Boolean getDivisionIsContractComplete() {
		return divisionIsContractComplete;
	}

	public void setDivisionIsContractComplete(Boolean divisionIsContractComplete) {
		this.divisionIsContractComplete = divisionIsContractComplete;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProcessorCode() {
		return processorCode;
	}

	public void setProcessorCode(String processorCode) {
		this.processorCode = processorCode;
	}

	public String getProcessorContactFirstName() {
		return processorContactFirstName;
	}

	public void setProcessorContactFirstName(String processorContactFirstName) {
		this.processorContactFirstName = processorContactFirstName;
	}

	public String getProcessorContactLastName() {
		return processorContactLastName;
	}

	public void setProcessorContactLastName(String processorContactLastName) {
		this.processorContactLastName = processorContactLastName;
	}

	public String getProcessorContactPhoneNumber() {
		return processorContactPhoneNumber;
	}

	public void setProcessorContactPhoneNumber(String processorContactPhoneNumber) {
		this.processorContactPhoneNumber = processorContactPhoneNumber;
	}

	public String getProcessorContactPhoneNumberExt() {
		return processorContactPhoneNumberExt;
	}

	public void setProcessorContactPhoneNumberExt(
			String processorContactPhoneNumberExt) {
		this.processorContactPhoneNumberExt = processorContactPhoneNumberExt;
	}

	public String getProcessorHasRealTimeIssuance() {
		return processorHasRealTimeIssuance;
	}

	public void setProcessorHasRealTimeIssuance(String processorHasRealTimeIssuance) {
		this.processorHasRealTimeIssuance = processorHasRealTimeIssuance;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public String getRecId() {
		return recId;
	}

	public void setRecId(String recId) {
		this.recId = recId;
	}

	public List<Store> getStores() {
		return stores;
	}

	public void setStores(List<Store> stores) {
		this.stores = stores;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}