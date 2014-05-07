package com.bhnetwork.integration.pppstodax.canonical;

import java.util.Date;

/**
 * 
 * BHN Integration canonical model for ItemId (also known as IID)
 * per spec 3.3, doc ref: MasterDataGapAnalysisGROUP 3PS v 3_3 .xlsx 
 * 
 * @author Stephane Rata - Got SOA?
 *
 */
public class ItemID {
	private String activationType;
	private String bhnGUID;
	private String caseCount;
	private String country;
	private String description;
	private String divisionBrandName;
	private String divisionCode;
	private String divisionCardImageURL;
	private String language;
	private String name;
	private String newIidReasonCode;
	private String packSize;
	private String prodPackType;
	private String useStdUnitConvert;   // or boolean?
	private String Iid;
}
