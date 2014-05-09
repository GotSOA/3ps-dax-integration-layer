package com.bhnetwork.integration.transformer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;

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
		
		//TODO real transformation.
		
		CustCompanyCodeServiceCreateRequest req= new CustCompanyCodeServiceCreateRequest();
		
		AxdCustCompanyCode custCompanyCode = new AxdCustCompanyCode();
		custCompanyCode.setDocPurpose(AxdEnumXMLDocPurpose.ORIGINAL);
	
		AxdEntityBhnCustCompanyTable bhnCustCompanyTable1 = new AxdEntityBhnCustCompanyTable();
		bhnCustCompanyTable1.setBhnSetupComplete(AxdExtTypeNoYesId.NO);
		bhnCustCompanyTable1.setCompanyCode("DEVQA");
		bhnCustCompanyTable1.setContractComplete(AxdEnumNoYes.NO);
		try {
			bhnCustCompanyTable1.setContractExpDate(stringToXMLGregorianCalendar("2014-05-05"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bhnCustCompanyTable1.setCountry("US");
		bhnCustCompanyTable1.setInactive(AxdExtTypeInactive.NO);
		bhnCustCompanyTable1.setName("DEVQA");
		bhnCustCompanyTable1.setRecId(123455L);
		bhnCustCompanyTable1.setRecVersion(654321678);
		bhnCustCompanyTable1.setSideLetterReq(AxdEnumNoYes.NO);
		bhnCustCompanyTable1.setTestDateReq(AxdEnumNoYes.NO);
		
		bhnCustCompanyTable1.setClazz("entity");
		
		AxdEntityBhnOnlineCompanyAttributes bhnOnlineCompanyAttributes1 = new AxdEntityBhnOnlineCompanyAttributes();
		bhnOnlineCompanyAttributes1.setCompanyCode("DEVQA");
		bhnOnlineCompanyAttributes1.setRecId(123456L);
		bhnOnlineCompanyAttributes1.setRecVersion(765432658);
		
		bhnOnlineCompanyAttributes1.setClazz("entity");
		
		bhnCustCompanyTable1.getBhnOnlineCompanyAttributes().add(bhnOnlineCompanyAttributes1);
		custCompanyCode.getBhnCustCompanyTable().add(bhnCustCompanyTable1);
		req.setCustCompanyCode(custCompanyCode);
		
		return req;
	}

	 private XMLGregorianCalendar stringToXMLGregorianCalendar(String s) 
		     throws ParseException, 
		            DatatypeConfigurationException
		 {
		 XMLGregorianCalendar result = null;
		 Date date;
		 SimpleDateFormat simpleDateFormat;
		 GregorianCalendar gregorianCalendar;
		 
		 simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		                date = simpleDateFormat.parse(s);        
		                gregorianCalendar = 
		                    (GregorianCalendar)GregorianCalendar.getInstance();
		                gregorianCalendar.setTime(date);
		                //result = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
		                result = DatatypeFactory.newInstance().newXMLGregorianCalendarDate(gregorianCalendar.get(Calendar.YEAR), gregorianCalendar.get(Calendar.MONTH)+1, gregorianCalendar.get(Calendar.DAY_OF_MONTH), DatatypeConstants.FIELD_UNDEFINED);
		                return result; 
		 }
}
