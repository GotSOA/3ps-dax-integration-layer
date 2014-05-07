package com.bhnetwork.integration.pppstodax.canonical;

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

public class Company {
	// per spec 3.2 company tab, DAX column
	private String bhnGUID;
	private Boolean isBhnSetupComplete;
	private String companyAddressLine1;
	private String companyAddressLine2;
	private String companyCity;
	private String companyCode;
	private String companyContractTerm;
	private String companyCountry;
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
	private Integer contractComplete;
	private Date contractExpDate;
	
	private List<Division> cpDivision;
	
	private List<ItemID> iid;
	
	private String legalEntityCode;
	private String legalEntityStateOfIncorporation;

	private List<ProductUpc> product;
	
	private List<SubstitutionGroup> substGrp;
	
}
