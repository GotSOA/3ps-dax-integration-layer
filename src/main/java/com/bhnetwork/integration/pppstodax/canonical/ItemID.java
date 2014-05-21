package com.bhnetwork.integration.pppstodax.canonical;

import java.io.Serializable;

/**
 * 
 * BHN Integration canonical model for ItemId (also known as IID) per spec 3.3,
 * doc ref: MasterDataGapAnalysisGROUP 3PS v 3_3 .xlsx
 * 
 * @author Stephane Rata - Got SOA?
 * 
 */
public class ItemID implements Serializable {
	private static final long serialVersionUID = 1L;
	private String bhnGUID;
	private String divisionBrandName;
	private String divisionCode;
	private String divisionCardImageURL;
	private String language;
	private String name;
	private String newIidReasonCode;
	private String iidActivationType;
	private Integer iidCaseCount;
	private String iidCountry;
	private String iidDescription;
	private Integer iidPackSize;
	private String iidProdPackType;
	private Boolean iidUseStdUnitConvert;
	private String inventBatchId;
	private String itemId;
	private String recId;
	public String getBhnGUID() {
		return bhnGUID;
	}
	public void setBhnGUID(String bhnGUID) {
		this.bhnGUID = bhnGUID;
	}
	public String getDivisionBrandName() {
		return divisionBrandName;
	}
	public void setDivisionBrandName(String divisionBrandName) {
		this.divisionBrandName = divisionBrandName;
	}
	public String getDivisionCode() {
		return divisionCode;
	}
	public void setDivisionCode(String divisionCode) {
		this.divisionCode = divisionCode;
	}
	public String getDivisionCardImageURL() {
		return divisionCardImageURL;
	}
	public void setDivisionCardImageURL(String divisionCardImageURL) {
		this.divisionCardImageURL = divisionCardImageURL;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNewIidReasonCode() {
		return newIidReasonCode;
	}
	public void setNewIidReasonCode(String newIidReasonCode) {
		this.newIidReasonCode = newIidReasonCode;
	}
	public String getIidActivationType() {
		return iidActivationType;
	}
	public void setIidActivationType(String iidActivationType) {
		this.iidActivationType = iidActivationType;
	}
	public Integer getIidCaseCount() {
		return iidCaseCount;
	}
	public void setIidCaseCount(Integer iidCaseCount) {
		this.iidCaseCount = iidCaseCount;
	}
	public String getIidCountry() {
		return iidCountry;
	}
	public void setIidCountry(String iidCountry) {
		this.iidCountry = iidCountry;
	}
	public String getIidDescription() {
		return iidDescription;
	}
	public void setIidDescription(String iidDescription) {
		this.iidDescription = iidDescription;
	}
	public Integer getIidPackSize() {
		return iidPackSize;
	}
	public void setIidPackSize(Integer iidPackSize) {
		this.iidPackSize = iidPackSize;
	}
	public String getIidProdPackType() {
		return iidProdPackType;
	}
	public void setIidProdPackType(String iidProdPackType) {
		this.iidProdPackType = iidProdPackType;
	}
	public Boolean getIidUseStdUnitConvert() {
		return iidUseStdUnitConvert;
	}
	public void setIidUseStdUnitConvert(Boolean iidUseStdUnitConvert) {
		this.iidUseStdUnitConvert = iidUseStdUnitConvert;
	}
	public String getInventBatchId() {
		return inventBatchId;
	}
	public void setInventBatchId(String inventBatchId) {
		this.inventBatchId = inventBatchId;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getRecId() {
		return recId;
	}
	public void setRecId(String recId) {
		this.recId = recId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
