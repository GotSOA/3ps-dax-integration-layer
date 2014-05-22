package com.bhnetwork.integration.pppstodax.canonical;

import java.io.Serializable;

/**
 * 
 * BHN Integration canonical model for Substitution Group
 * per spec 3.3, doc ref: MasterDataGapAnalysisGROUP 3PS v 3_3 .xlsx 
 * 
 * @author Stephane Rata - Got SOA?
 *
 */

public class SubstitutionGroup implements Serializable {
	private static final long serialVersionUID = 1L; 
	
	private String substitutionBrandDenomDescription;
	private String brandRecId;
	private String guid;
	private String substitutionCardDisplayDesc;
	private String substitutionPOG1Category;
	private String substitutionPOG2Category;
	private String substitutionPOG3Category;
	private String substitutionPortalDisplayName;
	private String substitutionPOGDimension;
	private String substitutionShipperUPC;
	private String subGroupId;
	public String getSubstitutionBrandDenomDescription() {
		return substitutionBrandDenomDescription;
	}
	public void setSubstitutionBrandDenomDescription(
			String substitutionBrandDenomDescription) {
		this.substitutionBrandDenomDescription = substitutionBrandDenomDescription;
	}
	public String getBrandRecId() {
		return brandRecId;
	}
	public void setBrandRecId(String brandRecId) {
		this.brandRecId = brandRecId;
	}
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	public String getSubstitutionCardDisplayDesc() {
		return substitutionCardDisplayDesc;
	}
	public void setSubstitutionCardDisplayDesc(String substitutionCardDisplayDesc) {
		this.substitutionCardDisplayDesc = substitutionCardDisplayDesc;
	}
	public String getSubstitutionPOG1Category() {
		return substitutionPOG1Category;
	}
	public void setSubstitutionPOG1Category(String substitutionPOG1Category) {
		this.substitutionPOG1Category = substitutionPOG1Category;
	}
	public String getSubstitutionPOG2Category() {
		return substitutionPOG2Category;
	}
	public void setSubstitutionPOG2Category(String substitutionPOG2Category) {
		this.substitutionPOG2Category = substitutionPOG2Category;
	}
	public String getSubstitutionPOG3Category() {
		return substitutionPOG3Category;
	}
	public void setSubstitutionPOG3Category(String substitutionPOG3Category) {
		this.substitutionPOG3Category = substitutionPOG3Category;
	}
	public String getSubstitutionPortalDisplayName() {
		return substitutionPortalDisplayName;
	}
	public void setSubstitutionPortalDisplayName(
			String substitutionPortalDisplayName) {
		this.substitutionPortalDisplayName = substitutionPortalDisplayName;
	}
	public String getSubstitutionPOGDimension() {
		return substitutionPOGDimension;
	}
	public void setSubstitutionPOGDimension(String substitutionPOGDimension) {
		this.substitutionPOGDimension = substitutionPOGDimension;
	}
	public String getSubstitutionShipperUPC() {
		return substitutionShipperUPC;
	}
	public void setSubstitutionShipperUPC(String substitutionShipperUPC) {
		this.substitutionShipperUPC = substitutionShipperUPC;
	}
	public String getSubGroupId() {
		return subGroupId;
	}
	public void setSubGroupId(String subGroupId) {
		this.subGroupId = subGroupId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
