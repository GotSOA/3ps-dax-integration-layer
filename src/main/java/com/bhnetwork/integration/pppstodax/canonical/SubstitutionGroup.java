package com.bhnetwork.integration.pppstodax.canonical;

/**
 * 
 * BHN Integration canonical model for Substitution Group
 * per spec 3.3, doc ref: MasterDataGapAnalysisGROUP 3PS v 3_3 .xlsx 
 * 
 * @author Stephane Rata - Got SOA?
 *
 */

public class SubstitutionGroup {
	
	private	String	brandDenomDescription;
	private	String	brandRecId;
	private	String	cardDisplayDesc;
	private	String	category1POG;
	private	String	category2POG;
	private	String	category3POG;
	private	String	dimensionPOG;
	private	String	divisionCode;
	private	String	guid;
	private	String	portalDisplayName;
	private	String	shipperUPC;
	private	String	subGroupId;
	public String getBrandDenomDescription() {
		return brandDenomDescription;
	}
	public void setBrandDenomDescription(String brandDenomDescription) {
		this.brandDenomDescription = brandDenomDescription;
	}
	public String getBrandRecId() {
		return brandRecId;
	}
	public void setBrandRecId(String brandRecId) {
		this.brandRecId = brandRecId;
	}
	public String getCardDisplayDesc() {
		return cardDisplayDesc;
	}
	public void setCardDisplayDesc(String cardDisplayDesc) {
		this.cardDisplayDesc = cardDisplayDesc;
	}
	public String getCategory1POG() {
		return category1POG;
	}
	public void setCategory1POG(String category1pog) {
		category1POG = category1pog;
	}
	public String getCategory2POG() {
		return category2POG;
	}
	public void setCategory2POG(String category2pog) {
		category2POG = category2pog;
	}
	public String getCategory3POG() {
		return category3POG;
	}
	public void setCategory3POG(String category3pog) {
		category3POG = category3pog;
	}
	public String getDimensionPOG() {
		return dimensionPOG;
	}
	public void setDimensionPOG(String dimensionPOG) {
		this.dimensionPOG = dimensionPOG;
	}
	public String getDivisionCode() {
		return divisionCode;
	}
	public void setDivisionCode(String divisionCode) {
		this.divisionCode = divisionCode;
	}
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	public String getPortalDisplayName() {
		return portalDisplayName;
	}
	public void setPortalDisplayName(String portalDisplayName) {
		this.portalDisplayName = portalDisplayName;
	}
	public String getShipperUPC() {
		return shipperUPC;
	}
	public void setShipperUPC(String shipperUPC) {
		this.shipperUPC = shipperUPC;
	}
	public String getSubGroupId() {
		return subGroupId;
	}
	public void setSubGroupId(String subGroupId) {
		this.subGroupId = subGroupId;
	}
	
	
}
