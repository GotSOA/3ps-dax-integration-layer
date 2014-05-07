package com.bhnetwork.integration.pppstodax.canonical;

/**
 * 
 * BHN Integration canonical model for Store (aka customer store)
 * per spec 3.3, doc ref: MasterDataGapAnalysisGROUP 3PS v 3_3 .xlsx 
 * 
 * @author Stephane Rata - Got SOA?
 *
 */
public class Store {
	    // bhn fields are DAX specific and may not need to be exposed in the json
		private	String	AccountNum;
		private	String	bhnCompanyCode;
		private	String	bhnDivisionCode;
		private	String	bhnGUID;
		private	String	bhnPartyType;
		private	String	bhnSyncEntityId;
		private	String	bhnSyncVersion;
		private	String	companyPhysicalStoreAddressLine1;
		private	String	companyPhysicalStoreCountry;
		private	String	County;
		private	String	Currency;
		private	Boolean	isSearchText;
		private	Boolean	isStoreBlocked;
		private	String	NameAlias;
		private	String	productLanguage;
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
}
