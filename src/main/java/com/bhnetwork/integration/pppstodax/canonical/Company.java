package com.bhnetwork.integration.pppstodax.canonical;

import java.io.Serializable;
import java.util.Date;

import java.util.List;

/**
 * 
 * BHN Integration canonical model for Company
 * per spec 3.3, doc ref: MasterDataGapAnalysisGROUP 3PS v 3_3 .xlsx 
 * 
 * @author Stephane Rata - Got SOA?
 *
 */

public class Company implements Serializable {
	private static final long serialVersionUID = 1L;
	private String bhnGUID;
	private String companyAddressLine1;
	private String companyAddressLine2;
	private Boolean companyBHNSetupComplete;
	private String companyCity;
	private String companyCode;
	private String companyContractTerm;
	private String companyCountry;
	private Boolean companyIsContractComplete;
	private String companyLegalName;
	private String companyMerchantCategoryCode;
	private String companyPrimaryContactBusinessTitle;
	private String companyPrimaryContactEmail;
	private String companyPrimaryContactFirstName;
	private String companyPrimaryContactLastName;
	private String companyPrimaryPhoneNumber;
	private String companyPrimaryPhoneNumberExt;
	private String companyState;
	private String companyWebSiteURL;
	private String companyZipPostalCode;
	private Date contractExpDate;
	
	private List<Division> cpDivision;	
	
	private String legalEntityCode;
	private String legalEntityStateOfIncorporation;
	private String recId;
	public String getBhnGUID() {
		return bhnGUID;
	}
	public void setBhnGUID(String bhnGUID) {
		this.bhnGUID = bhnGUID;
	}
	public String getCompanyAddressLine1() {
		return companyAddressLine1;
	}
	public void setCompanyAddressLine1(String companyAddressLine1) {
		this.companyAddressLine1 = companyAddressLine1;
	}
	public String getCompanyAddressLine2() {
		return companyAddressLine2;
	}
	public void setCompanyAddressLine2(String companyAddressLine2) {
		this.companyAddressLine2 = companyAddressLine2;
	}
	public Boolean getCompanyBHNSetupComplete() {
		return companyBHNSetupComplete;
	}
	public void setCompanyBHNSetupComplete(Boolean companyBHNSetupComplete) {
		this.companyBHNSetupComplete = companyBHNSetupComplete;
	}
	public String getCompanyCity() {
		return companyCity;
	}
	public void setCompanyCity(String companyCity) {
		this.companyCity = companyCity;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getCompanyContractTerm() {
		return companyContractTerm;
	}
	public void setCompanyContractTerm(String companyContractTerm) {
		this.companyContractTerm = companyContractTerm;
	}
	public String getCompanyCountry() {
		return companyCountry;
	}
	public void setCompanyCountry(String companyCountry) {
		this.companyCountry = companyCountry;
	}
	public Boolean getCompanyIsContractComplete() {
		return companyIsContractComplete;
	}
	public void setCompanyIsContractComplete(Boolean companyIsContractComplete) {
		this.companyIsContractComplete = companyIsContractComplete;
	}
	public String getCompanyLegalName() {
		return companyLegalName;
	}
	public void setCompanyLegalName(String companyLegalName) {
		this.companyLegalName = companyLegalName;
	}
	public String getCompanyMerchantCategoryCode() {
		return companyMerchantCategoryCode;
	}
	public void setCompanyMerchantCategoryCode(String companyMerchantCategoryCode) {
		this.companyMerchantCategoryCode = companyMerchantCategoryCode;
	}
	public String getCompanyPrimaryContactBusinessTitle() {
		return companyPrimaryContactBusinessTitle;
	}
	public void setCompanyPrimaryContactBusinessTitle(
			String companyPrimaryContactBusinessTitle) {
		this.companyPrimaryContactBusinessTitle = companyPrimaryContactBusinessTitle;
	}
	public String getCompanyPrimaryContactEmail() {
		return companyPrimaryContactEmail;
	}
	public void setCompanyPrimaryContactEmail(String companyPrimaryContactEmail) {
		this.companyPrimaryContactEmail = companyPrimaryContactEmail;
	}
	public String getCompanyPrimaryContactFirstName() {
		return companyPrimaryContactFirstName;
	}
	public void setCompanyPrimaryContactFirstName(
			String companyPrimaryContactFirstName) {
		this.companyPrimaryContactFirstName = companyPrimaryContactFirstName;
	}
	public String getCompanyPrimaryContactLastName() {
		return companyPrimaryContactLastName;
	}
	public void setCompanyPrimaryContactLastName(
			String companyPrimaryContactLastName) {
		this.companyPrimaryContactLastName = companyPrimaryContactLastName;
	}
	public String getCompanyPrimaryPhoneNumber() {
		return companyPrimaryPhoneNumber;
	}
	public void setCompanyPrimaryPhoneNumber(String companyPrimaryPhoneNumber) {
		this.companyPrimaryPhoneNumber = companyPrimaryPhoneNumber;
	}
	public String getCompanyPrimaryPhoneNumberExt() {
		return companyPrimaryPhoneNumberExt;
	}
	public void setCompanyPrimaryPhoneNumberExt(String companyPrimaryPhoneNumberExt) {
		this.companyPrimaryPhoneNumberExt = companyPrimaryPhoneNumberExt;
	}
	public String getCompanyState() {
		return companyState;
	}
	public void setCompanyState(String companyState) {
		this.companyState = companyState;
	}
	public String getCompanyWebSiteURL() {
		return companyWebSiteURL;
	}
	public void setCompanyWebSiteURL(String companyWebSiteURL) {
		this.companyWebSiteURL = companyWebSiteURL;
	}
	public String getCompanyZipPostalCode() {
		return companyZipPostalCode;
	}
	public void setCompanyZipPostalCode(String companyZipPostalCode) {
		this.companyZipPostalCode = companyZipPostalCode;
	}
	public Date getContractExpDate() {
		return contractExpDate;
	}
	public void setContractExpDate(Date contractExpDate) {
		this.contractExpDate = contractExpDate;
	}
	public List<Division> getCpDivision() {
		return cpDivision;
	}
	public void setCpDivision(List<Division> cpDivision) {
		this.cpDivision = cpDivision;
	}
	public String getLegalEntityCode() {
		return legalEntityCode;
	}
	public void setLegalEntityCode(String legalEntityCode) {
		this.legalEntityCode = legalEntityCode;
	}
	public String getLegalEntityStateOfIncorporation() {
		return legalEntityStateOfIncorporation;
	}
	public void setLegalEntityStateOfIncorporation(
			String legalEntityStateOfIncorporation) {
		this.legalEntityStateOfIncorporation = legalEntityStateOfIncorporation;
	}
	public String getRecId() {
		return recId;
	}
	public void setRecId(String recId) {
		this.recId = recId;
	}	
			
}