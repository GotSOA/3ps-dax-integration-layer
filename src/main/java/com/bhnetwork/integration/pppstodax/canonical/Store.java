package com.bhnetwork.integration.pppstodax.canonical;

import java.io.Serializable;

/**
 * 
 * BHN Integration canonical model for Store (aka customer store)
 * per spec 3.3, doc ref: MasterDataGapAnalysisGROUP 3PS v 3_3 .xlsx 
 * 
 * @author Stephane Rata - Got SOA?
 *
 */
public class Store implements Serializable {
		private static final long serialVersionUID = 1L;
	    // bhn fields are DAX specific and may not need to be exposed in the json
		private	String	AccountNum;
		private	String	bhnCompanyCode;
		private	String	bhnDivisionCode;
		private	String	bhnGUID;
		private	String	companyPhysicalStoreAddressLine1;
		private	String	companyPhysicalStoreCountry;
		private	String	productLanguage;
		private	Boolean	storeBlocked;
		private	String	storeBHNCustLevel;
		private	String	storeBHNStoreCode;
		private	String	storeChannelDimension;
		private	String	storeContactPhoneNumber;
		private	String	storeCountryRegionId;
		private	String	storeCustGroup;
		private	String	storeDimensionPAC;
		private	String	storeDimensionRegion;
		private	String	storePhysicalStoreAddressLine1;
		private	String	storePhysicalStoreAddressLine2;
		private	String	storePhysicalStoreCity;
		private	String	storePhysicalStoreName;
		private	String	storePhysicalStorePostalCode;
		private	String	storePhysicalStoreState;
		private	String	storePriceToleranceGroup;
		public String getAccountNum() {
			return AccountNum;
		}
		public void setAccountNum(String accountNum) {
			AccountNum = accountNum;
		}
		public String getBhnCompanyCode() {
			return bhnCompanyCode;
		}
		public void setBhnCompanyCode(String bhnCompanyCode) {
			this.bhnCompanyCode = bhnCompanyCode;
		}
		public String getBhnDivisionCode() {
			return bhnDivisionCode;
		}
		public void setBhnDivisionCode(String bhnDivisionCode) {
			this.bhnDivisionCode = bhnDivisionCode;
		}
		public String getBhnGUID() {
			return bhnGUID;
		}
		public void setBhnGUID(String bhnGUID) {
			this.bhnGUID = bhnGUID;
		}
		public String getCompanyPhysicalStoreAddressLine1() {
			return companyPhysicalStoreAddressLine1;
		}
		public void setCompanyPhysicalStoreAddressLine1(
				String companyPhysicalStoreAddressLine1) {
			this.companyPhysicalStoreAddressLine1 = companyPhysicalStoreAddressLine1;
		}
		public String getCompanyPhysicalStoreCountry() {
			return companyPhysicalStoreCountry;
		}
		public void setCompanyPhysicalStoreCountry(String companyPhysicalStoreCountry) {
			this.companyPhysicalStoreCountry = companyPhysicalStoreCountry;
		}
		public String getProductLanguage() {
			return productLanguage;
		}
		public void setProductLanguage(String productLanguage) {
			this.productLanguage = productLanguage;
		}
		public Boolean getStoreBlocked() {
			return storeBlocked;
		}
		public void setStoreBlocked(Boolean storeBlocked) {
			this.storeBlocked = storeBlocked;
		}
		public String getStoreBHNCustLevel() {
			return storeBHNCustLevel;
		}
		public void setStoreBHNCustLevel(String storeBHNCustLevel) {
			this.storeBHNCustLevel = storeBHNCustLevel;
		}
		public String getStoreBHNStoreCode() {
			return storeBHNStoreCode;
		}
		public void setStoreBHNStoreCode(String storeBHNStoreCode) {
			this.storeBHNStoreCode = storeBHNStoreCode;
		}
		public String getStoreChannelDimension() {
			return storeChannelDimension;
		}
		public void setStoreChannelDimension(String storeChannelDimension) {
			this.storeChannelDimension = storeChannelDimension;
		}
		public String getStoreContactPhoneNumber() {
			return storeContactPhoneNumber;
		}
		public void setStoreContactPhoneNumber(String storeContactPhoneNumber) {
			this.storeContactPhoneNumber = storeContactPhoneNumber;
		}
		public String getStoreCountryRegionId() {
			return storeCountryRegionId;
		}
		public void setStoreCountryRegionId(String storeCountryRegionId) {
			this.storeCountryRegionId = storeCountryRegionId;
		}
		public String getStoreCustGroup() {
			return storeCustGroup;
		}
		public void setStoreCustGroup(String storeCustGroup) {
			this.storeCustGroup = storeCustGroup;
		}
		public String getStoreDimensionPAC() {
			return storeDimensionPAC;
		}
		public void setStoreDimensionPAC(String storeDimensionPAC) {
			this.storeDimensionPAC = storeDimensionPAC;
		}
		public String getStoreDimensionRegion() {
			return storeDimensionRegion;
		}
		public void setStoreDimensionRegion(String storeDimensionRegion) {
			this.storeDimensionRegion = storeDimensionRegion;
		}
		public String getStorePhysicalStoreAddressLine1() {
			return storePhysicalStoreAddressLine1;
		}
		public void setStorePhysicalStoreAddressLine1(
				String storePhysicalStoreAddressLine1) {
			this.storePhysicalStoreAddressLine1 = storePhysicalStoreAddressLine1;
		}
		public String getStorePhysicalStoreAddressLine2() {
			return storePhysicalStoreAddressLine2;
		}
		public void setStorePhysicalStoreAddressLine2(
				String storePhysicalStoreAddressLine2) {
			this.storePhysicalStoreAddressLine2 = storePhysicalStoreAddressLine2;
		}
		public String getStorePhysicalStoreCity() {
			return storePhysicalStoreCity;
		}
		public void setStorePhysicalStoreCity(String storePhysicalStoreCity) {
			this.storePhysicalStoreCity = storePhysicalStoreCity;
		}
		public String getStorePhysicalStoreName() {
			return storePhysicalStoreName;
		}
		public void setStorePhysicalStoreName(String storePhysicalStoreName) {
			this.storePhysicalStoreName = storePhysicalStoreName;
		}
		public String getStorePhysicalStorePostalCode() {
			return storePhysicalStorePostalCode;
		}
		public void setStorePhysicalStorePostalCode(String storePhysicalStorePostalCode) {
			this.storePhysicalStorePostalCode = storePhysicalStorePostalCode;
		}
		public String getStorePhysicalStoreState() {
			return storePhysicalStoreState;
		}
		public void setStorePhysicalStoreState(String storePhysicalStoreState) {
			this.storePhysicalStoreState = storePhysicalStoreState;
		}
		public String getStorePriceToleranceGroup() {
			return storePriceToleranceGroup;
		}
		public void setStorePriceToleranceGroup(String storePriceToleranceGroup) {
			this.storePriceToleranceGroup = storePriceToleranceGroup;
		}
						
}
