package com.bhnetwork.integration.transformer;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.api.transport.PropertyScope;
import org.mule.transformer.AbstractMessageTransformer;

import com.bhnetwork.integration.pppstodax.canonical.Vendor;
import com.bhnetwork.integration.pppstodax.canonical.PartnerProfile;
import com.microsoft.schemas.dynamics._2008._01.documents.vendtable.AxdVendTable;
import com.microsoft.schemas.dynamics._2008._01.documents.vendtable.AxdEntityVendTable;
import com.microsoft.schemas.dynamics._2008._01.documents.vendtable.AxdEntityVendorAddress;
import com.microsoft.schemas.dynamics._2008._01.documents.vendtable.AxdArrayAxdExtTypeDimension;
import com.microsoft.schemas.dynamics._2008._01.documents.vendtable.AxdEnumNoYes;
import com.microsoft.schemas.dynamics._2008._01.documents.vendtable.AxdExtTypeNoYesId;
import com.microsoft.schemas.dynamics._2008._01.services.VendTableServiceCreateRequest;
import com.microsoft.schemas.dynamics._2008._01.services.AxdEnumTaxIdType;



public class CanonicalToVendTableServiceCreateRequest extends
		AbstractMessageTransformer {

	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding)
			throws TransformerException {
		
		
		Vendor vendorObj = ((PartnerProfile) message.getPayload()).getVendor();	
		
		VendTableServiceCreateRequest req= new VendTableServiceCreateRequest();
		
		// companyCode is the pkey for company, what's the equivalent for Vendor?
		// AxdCustCompanyCode custCompanyCode = new AxdCustCompanyCode();
		
		AxdEntityVendTable bhnVendorTable1 = new AxdEntityVendTable();
		
		/* fields of the canonical
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
		private String vendorEmail;
		private Boolean vendorForeignEntityIndicator;
		private String vendorGroup;
		private String vendorLanguageId;
		private String vendorPaymentTermsId;
		private String vendorPaymMode;
		private String vendorPhone;
		private String vendorState;
		private String vendorstreet;
		private String vendorTax1099NameChoice;
		private String vendorTax1099Reports;
		private String vendorTaxIDNumber;			// not sure how to map this one
		private Boolean vendorW9;
		private String vendorZipCode;
		*/
		
		bhnVendorTable1.setAccountNum(vendorObj.getAccountNum());
		//bhnVendorTable1.setAction(value);
		bhnVendorTable1.setAddress(vendorObj.getVendorAddress());
		//bhnVendorTable1.setBankAccount(value);
		//bhnVendorTable1.setBankCentralBankPurposeCode(value);
		//bhnVendorTable1.setBankCentralBankPurposeText(value);
		//bhnVendorTable1.setBidOnly(value);
		bhnVendorTable1.setBlocked(vendorObj.getVendorBlocked());
		//bhnVendorTable1.setCashDisc(value);
		//bhnVendorTable1.setCellularPhone(value);
		bhnVendorTable1.setCity(vendorObj.getVendorCity());
		//bhnVendorTable1.setClazz(value);
		//bhnVendorTable1.setClearingPeriod(value);
		//bhnVendorTable1.setCompanyChainId(value);
		//bhnVendorTable1.setContactPersonId(value);
		bhnVendorTable1.setCountryRegionId(vendorObj.getVendorCountryRegionId());
		bhnVendorTable1.setCounty(vendorObj.getVendorCounty());
		//bhnVendorTable1.setCreditMax(value);
		//bhnVendorTable1.setCreditRating(value);
		bhnVendorTable1.setCurrency(vendorObj.getVendorCurrency());
		//bhnVendorTable1.setCustAccount(value);
		//bhnVendorTable1.setDBA(value);
		//bhnVendorTable1.setDestinationCodeId(value);
		//bhnVendorTable1.setDimension(value);
		//bhnVendorTable1.setDlvMode(value);
		//bhnVendorTable1.setDlvTerm(value);
		//bhnVendorTable1.setDocumentHash(value);
		bhnVendorTable1.setEmail(vendorObj.getVendorEmail());
		//bhnVendorTable1.setEndDisc(value);
		bhnVendorTable1.setForeignEntityIndicator(vendorObj.getVendorForeignEntityIndicator());
		//bhnVendorTable1.setFreightZone(value);
		//bhnVendorTable1.setInclTax(value);
		//bhnVendorTable1.setInventLocation(value);
		//bhnVendorTable1.setInventSiteId(value);
		//bhnVendorTable1.setItemBuyerGroupId(value);
		bhnVendorTable1.setLanguageId(vendorObj.getVendorLanguageId());
		//bhnVendorTable1.setLineDisc(value);
		//bhnVendorTable1.setLineOfBusinessId(value);
		//bhnVendorTable1.setLocallyOwned(value);
		//bhnVendorTable1.setMainContactId(value);
		//bhnVendorTable1.setMarkupGroup(value);
		//bhnVendorTable1.setMemo(value);
		//bhnVendorTable1.setMerchRecordNumber(value);
		//bhnVendorTable1.setMultiLineDisc(value);
		bhnVendorTable1.setName(vendorObj.getCompanyLegalName());
		//bhnVendorTable1.setNameAlias(value);
		//bhnVendorTable1.setNameControl(value);
		//bhnVendorTable1.setNumberSequenceGroup(value);
		//bhnVendorTable1.setOffsetAccount(value);
		//bhnVendorTable1.setOffsetAccountType(value);
		//bhnVendorTable1.setOneTimeVendor(value);
		//bhnVendorTable1.setPager(value);
		//bhnVendorTable1.setPartnerProfileId(value);
		//bhnVendorTable1.setPartyId(value);
		//bhnVendorTable1.setPartyType(value);
		//bhnVendorTable1.setPaymDayId(value);
		//bhnVendorTable1.setPaymId(value);
		bhnVendorTable1.setPaymMode(vendorObj.getVendorPaymMode());
		//bhnVendorTable1.setPaymSched(value);
		//bhnVendorTable1.setPaymSpec(value);
		bhnVendorTable1.setPaymTermId(vendorObj.getVendorPaymentTermsId());
		bhnVendorTable1.setPhone(vendorObj.getVendorPhone());
		//bhnVendorTable1.setPhoneLocal(value);
		//bhnVendorTable1.setPriceGroup(value);
		//bhnVendorTable1.setPurchAmountPurchaseOrder(value);
		//bhnVendorTable1.setPurchCalendarId(value);
		//bhnVendorTable1.setPurchPoolId(value);
		//bhnVendorTable1.setSecondTIN(value);
		//bhnVendorTable1.setSegmentId(value);
		//bhnVendorTable1.setSmallBusiness(value);
		//bhnVendorTable1.setSMS(value);
		bhnVendorTable1.setState(vendorObj.getVendorState());
		bhnVendorTable1.setStreet(vendorObj.getVendorstreet());
		//bhnVendorTable1.setSubsegmentId(value);
		//bhnVendorTable1.setSuppItemGroupId(value);
		//bhnVendorTable1.setTax1099Box(value);
		bhnVendorTable1.setTax1099NameChoice(vendorObj.getVendorTax1099NameChoice());
		bhnVendorTable1.setTax1099RegNum(vendorObj.getVendorTaxIDNumber());
		bhnVendorTable1.setTax1099Reports(vendorObj.getVendorTax1099Reports());
		//bhnVendorTable1.setTaxGroup(value);
		bhnVendorTable1.setTaxIDType(value);				// is it for individual vs. corporate ?
		//bhnVendorTable1.setTaxWithholdCalculate(value);
		//bhnVendorTable1.setTaxWithholdGroup(value);
		//bhnVendorTable1.setTeleFax(value);
		//bhnVendorTable1.setTelex(value);
		//bhnVendorTable1.setURL(value);
		//bhnVendorTable1.setVATNum(value);
		bhnVendorTable1.setVendGroup(vendorObj.getVendorGroup());
		//bhnVendorTable1.setVendItemGroupId(value);
		//bhnVendorTable1.setVendPriceToleranceGroupId(value);
		bhnVendorTable1.setW9(vendorObj.getVendorW9());
		//bhnVendorTable1.setYourAccountNum(value);
		bhnVendorTable1.setZipCode(vendorObj.getVendorZipCode());
		
		// 137 -45 + 1 = 93 fields
		
		// sample code to handle ENUMS
		//bhnCustCompanyTable1.setBhnSetupComplete(companyObj.getCompanyBHNSetupComplete()? AxdExtTypeNoYesId.YES:AxdExtTypeNoYesId.NO);
		//bhnCustCompanyTable1.setCompanyCode(companyObj.getCompanyCode());
		
		return req;
	}
	
	private XMLGregorianCalendar dateToXMLGregorianCalendar(Date date)
			throws ParseException, DatatypeConfigurationException {
		XMLGregorianCalendar result = null;
		GregorianCalendar gregorianCalendar;

		gregorianCalendar = (GregorianCalendar) GregorianCalendar.getInstance();
		gregorianCalendar.setTime(date);
		result = DatatypeFactory.newInstance().newXMLGregorianCalendarDate(
				gregorianCalendar.get(Calendar.YEAR),
				gregorianCalendar.get(Calendar.MONTH) + 1,
				gregorianCalendar.get(Calendar.DAY_OF_MONTH),
				DatatypeConstants.FIELD_UNDEFINED);
		return result;
	}
}