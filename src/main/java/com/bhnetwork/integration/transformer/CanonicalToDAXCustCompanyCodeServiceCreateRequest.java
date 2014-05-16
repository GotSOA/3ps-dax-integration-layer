package com.bhnetwork.integration.transformer;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;

import com.bhnetwork.integration.pppstodax.canonical.Company;
import com.microsoft.schemas.dynamics._2008._01.documents.custcompanycode.AxdCustCompanyCode;
import com.microsoft.schemas.dynamics._2008._01.documents.custcompanycode.AxdEntityBhnCustCompanyTable;
import com.microsoft.schemas.dynamics._2008._01.documents.custcompanycode.AxdEntityBhnOnlineCompanyAttributes;
import com.microsoft.schemas.dynamics._2008._01.documents.custcompanycode.AxdEnumNoYes;
import com.microsoft.schemas.dynamics._2008._01.documents.custcompanycode.AxdEnumXMLDocPurpose;
import com.microsoft.schemas.dynamics._2008._01.documents.custcompanycode.AxdExtTypeInactive;
import com.microsoft.schemas.dynamics._2008._01.documents.custcompanycode.AxdExtTypeNoYesId;
import com.microsoft.schemas.dynamics._2008._01.services.CustCompanyCodeServiceCreateRequest;

public class CanonicalToDAXCustCompanyCodeServiceCreateRequest extends AbstractTransformer{

	@Override
	protected Object doTransform(Object src, String enc)
			throws TransformerException {
		
		Company companyObj = (Company) src;		
		
		CustCompanyCodeServiceCreateRequest req= new CustCompanyCodeServiceCreateRequest();
		
		AxdCustCompanyCode custCompanyCode = new AxdCustCompanyCode();
		
		AxdEntityBhnCustCompanyTable bhnCustCompanyTable1 = new AxdEntityBhnCustCompanyTable();
		bhnCustCompanyTable1.setBhnSetupComplete(companyObj.getCompanyBHNSetupComplete()? AxdExtTypeNoYesId.YES:AxdExtTypeNoYesId.NO);
		bhnCustCompanyTable1.setCompanyCode(companyObj.getCompanyCode());
		bhnCustCompanyTable1.setContractComplete(companyObj.getCompanyIsContractComplete()? AxdEnumNoYes.YES: AxdEnumNoYes.NO);
		try {
			bhnCustCompanyTable1.setContractExpDate(dateToXMLGregorianCalendar(companyObj.getContractExpDate()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bhnCustCompanyTable1.setCorporateName(companyObj.getCompanyLegalName());
		bhnCustCompanyTable1.setCountry(companyObj.getCompanyCountry());
		bhnCustCompanyTable1.setInactive(AxdExtTypeInactive.NO);
		bhnCustCompanyTable1.setLegalEntityCode(companyObj.getLegalEntityCode());
		bhnCustCompanyTable1.setName(companyObj.getCompanyCode());
		
		bhnCustCompanyTable1.setPartnerProfileId("partner_profile_id_12345");
		
		//XML Attribute required
		bhnCustCompanyTable1.setClazz("entity");//TODO Not in SPEC
		
		AxdEntityBhnOnlineCompanyAttributes bhnOnlineCompanyAttributes1 = new AxdEntityBhnOnlineCompanyAttributes();
		bhnOnlineCompanyAttributes1.setCompanyAddressLine1(companyObj.getCompanyAddressLine1());
		bhnOnlineCompanyAttributes1.setCompanyAddressLine2(companyObj.getCompanyAddressLine2());
		bhnOnlineCompanyAttributes1.setCompanycity(companyObj.getCompanyCity());
		bhnOnlineCompanyAttributes1.setCompanyCode(companyObj.getCompanyCode());
		bhnOnlineCompanyAttributes1.setCompanyContractTerm(companyObj.getCompanyContractTerm());
		bhnOnlineCompanyAttributes1.setCompanyMerchantCategoryCode(companyObj.getCompanyMerchantCategoryCode());
		bhnOnlineCompanyAttributes1.setCompanyPrimaryContactBusinessTitle(companyObj.getCompanyPrimaryContactBusinessTitle());
		bhnOnlineCompanyAttributes1.setCompanyPrimaryContactEmail(companyObj.getCompanyPrimaryContactEmail());
		bhnOnlineCompanyAttributes1.setCompanyPrimaryContactFirstName(companyObj.getCompanyPrimaryContactFirstName());
		bhnOnlineCompanyAttributes1.setCompanyPrimaryContactLastName(companyObj.getCompanyPrimaryContactLastName());
		bhnOnlineCompanyAttributes1.setCompanyPrimaryPhoneNumber(companyObj.getCompanyPrimaryPhoneNumber());
		bhnOnlineCompanyAttributes1.setCompanyPrimaryPhoneNumberExt(companyObj.getCompanyPrimaryPhoneNumberExt());
		bhnOnlineCompanyAttributes1.setCompanyState(companyObj.getCompanyState());
		bhnOnlineCompanyAttributes1.setCompanyWebSiteURL(companyObj.getCompanyWebSiteURL());
		bhnOnlineCompanyAttributes1.setCompanyZipPostalCode(companyObj.getCompanyZipPostalCode());
		bhnOnlineCompanyAttributes1.setLegalEntityStateOfIncorporation(companyObj.getLegalEntityStateOfIncorporation());
		
		//XML Attribute required
		bhnOnlineCompanyAttributes1.setClazz("entity");//TODO Not in SPEC
		
		bhnCustCompanyTable1.getBhnOnlineCompanyAttributes().add(bhnOnlineCompanyAttributes1);
		custCompanyCode.getBhnCustCompanyTable().add(bhnCustCompanyTable1);
		req.setCustCompanyCode(custCompanyCode);
		
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
