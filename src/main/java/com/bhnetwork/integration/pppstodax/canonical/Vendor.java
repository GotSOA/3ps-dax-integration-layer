package com.bhnetwork.integration.pppstodax.canonical;

import java.io.Serializable;

/**
 * 
 * BHN Integration canonical model for Vendor per spec 3.3, doc ref:
 * MasterDataGapAnalysisGROUP 3PS v 3_3 .xlsx
 * 
 * @author Stephane Rata - Got SOA?
 * 
 */

public class Vendor implements Serializable {
	private static final long serialVersionUID = 1L;
	// spec 3.10
	private String accountNum;
	private String companyLegalName;
	private String divisionBrandName;
	private String recId;
	private String vendorAddress;
	private Boolean vendorBlocked;
	private String vendorCity;
	private String vendorCountryRegionId;
	private String vendorCounty;
	private String vendorCurrency;
	private String vendorDBA;		// maps to vendorDBAName
	private String vendorEmail;
	private Boolean vendorForeignEntityIndicator;
	private String vendorGroup;      // required
	private String vendorLanguageId;
	private String vendorName;		// maps to vendorNameFor1099
	private String vendorPartyType;		//  DAX generated  
	private String vendorPaymentTermsId;
	private String vendorPaymMode;
	private String vendorPhone;
	private String vendorState;
	private String vendorStreet;
	private String vendorTax1099NameChoice;
	private String vendorTax1099Reports;
	private String vendorTaxGroup; 		// optional e.g. STOUSCA
	private String vendorTaxIDNumber;		// maps to Tax1099RegNum
	private String vendorTaxIdType;
	private String vendorURL;
	private Boolean vendorW9;
	private String vendorZipCode;
	
	public String getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	public String getCompanyLegalName() {
		return companyLegalName;
	}
	public void setCompanyLegalName(String companyLegalName) {
		this.companyLegalName = companyLegalName;
	}
	public String getDivisionBrandName() {
		return divisionBrandName;
	}
	public void setDivisionBrandName(String divisionBrandName) {
		this.divisionBrandName = divisionBrandName;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getVendorPartyType() {
		return vendorPartyType;
	}
	public void setVendorPartyType(String vendorPartyType) {
		this.vendorPartyType = vendorPartyType;
	}	
	public String getRecId() {
		return recId;
	}
	public void setRecId(String recId) {
		this.recId = recId;
	}
	public String getVendorAddress() {
		return vendorAddress;
	}
	public void setVendorAddress(String vendorAddress) {
		this.vendorAddress = vendorAddress;
	}
	public Boolean getVendorBlocked() {
		return vendorBlocked;
	}
	public void setVendorBlocked(Boolean vendorBlocked) {
		this.vendorBlocked = vendorBlocked;
	}
	public String getVendorCity() {
		return vendorCity;
	}
	public void setVendorCity(String vendorCity) {
		this.vendorCity = vendorCity;
	}
	public String getVendorDBA() {
		return vendorDBA;
	}
	public void setVendorDBA(String vendorDba) {
		this.vendorDBA = vendorDba;
	}	
	public String getVendorCountryRegionId() {
		return vendorCountryRegionId;
	}
	public void setVendorCountryRegionId(String vendorCountryRegionId) {
		this.vendorCountryRegionId = vendorCountryRegionId;
	}
	public String getVendorCounty() {
		return vendorCounty;
	}
	public void setVendorCounty(String vendorCounty) {
		this.vendorCounty = vendorCounty;
	}
	public String getVendorCurrency() {
		return vendorCurrency;
	}
	public void setVendorCurrency(String vendorCurrency) {
		this.vendorCurrency = vendorCurrency;
	}
	public String getVendorEmail() {
		return vendorEmail;
	}
	public void setVendorEmail(String vendorEmail) {
		this.vendorEmail = vendorEmail;
	}
	public Boolean getVendorForeignEntityIndicator() {
		return vendorForeignEntityIndicator;
	}
	public void setVendorForeignEntityIndicator(Boolean vendorForeignEntityIndicator) {
		this.vendorForeignEntityIndicator = vendorForeignEntityIndicator;
	}
	public String getVendorGroup() {
		return vendorGroup;
	}
	public void setVendorGroup(String vendorGroup) {
		this.vendorGroup = vendorGroup;
	}
	public String getVendorLanguageId() {
		return vendorLanguageId;
	}
	public void setVendorLanguageId(String vendorLanguageId) {
		this.vendorLanguageId = vendorLanguageId;
	}
	public String getVendorPaymentTermsId() {
		return vendorPaymentTermsId;
	}
	public void setVendorPaymentTermsId(String vendorPaymentTermsId) {
		this.vendorPaymentTermsId = vendorPaymentTermsId;
	}
	public String getVendorPaymMode() {
		return vendorPaymMode;
	}
	public void setVendorPaymMode(String vendorPaymMode) {
		this.vendorPaymMode = vendorPaymMode;
	}
	public String getVendorPhone() {
		return vendorPhone;
	}
	public void setVendorPhone(String vendorPhone) {
		this.vendorPhone = vendorPhone;
	}
	public String getVendorState() {
		return vendorState;
	}
	public void setVendorState(String vendorState) {
		this.vendorState = vendorState;
	}
	public String getVendorStreet() {
		return vendorStreet;
	}
	public void setVendorStreet(String vendorStreet) {
		this.vendorStreet = vendorStreet;
	}
	public String getVendorTax1099NameChoice() {
		return vendorTax1099NameChoice;
	}
	public void setVendorTax1099NameChoice(String vendorTax1099NameChoice) {
		this.vendorTax1099NameChoice = vendorTax1099NameChoice;
	}
	public String getVendorTax1099Reports() {
		return vendorTax1099Reports;
	}
	public void setVendorTax1099Reports(String vendorTax1099Reports) {
		this.vendorTax1099Reports = vendorTax1099Reports;
	}	
	public String getVendorTaxIDNumber() {
		return vendorTaxIDNumber;
	}
	public void setVendorTaxIDNumber(String vendorTaxIDNumber) {
		this.vendorTaxIDNumber = vendorTaxIDNumber;
	}
	public String getVendorTaxGroup() {
		return vendorTaxGroup;
	}
	public void setVendorTaxGroup(String vendorTaxGroup) {
		this.vendorTaxGroup = vendorTaxGroup;
	}	
	public String getVendorTaxIdType() {
		return vendorTaxIdType;
	}
	public void setVendorTaxIdType(String vendorTaxIdType) {
		this.vendorTaxIdType = vendorTaxIdType;
	}
	public String getVendorURL() {
		return vendorURL;
	}
	public void setVendorURL(String vendorURL) {
		this.vendorURL = vendorURL;
	}
	public Boolean getVendorW9() {
		return vendorW9;
	}
	public void setVendorW9(Boolean vendorW9) {
		this.vendorW9 = vendorW9;
	}
	public String getVendorZipCode() {
		return vendorZipCode;
	}
	public void setVendorZipCode(String vendorZipCode) {
		this.vendorZipCode = vendorZipCode;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
