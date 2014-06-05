package com.bhnetwork.integration.transformer;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.api.transport.PropertyScope;
import org.mule.transformer.AbstractMessageTransformer;

import com.bhnetwork.integration.pppstodax.canonical.Store;
import com.bhnetwork.integration.pppstodax.canonical.Vendor;
import com.bhnetwork.integration.pppstodax.canonical.PartnerProfile;

import com.microsoft.schemas.dynamics._2008._01.documents.customer.AxdEntityCustTable;
import com.microsoft.schemas.dynamics._2008._01.documents.customer.AxdArrayAxdExtTypeDimension;
import com.microsoft.schemas.dynamics._2008._01.documents.customer.AxdCustomer;
import com.microsoft.schemas.dynamics._2008._01.documents.customer.AxdEntityAddressRelationship;
import com.microsoft.schemas.dynamics._2008._01.documents.customer.AxdEntityCustAddress;
import com.microsoft.schemas.dynamics._2008._01.documents.customer.AxdExtTypeBhnCustomerLevel;
import com.microsoft.schemas.dynamics._2008._01.documents.customer.AxdExtTypeCustBlocked;

import com.microsoft.schemas.dynamics._2008._01.services.CustomerServiceCreateRequest;

public class CanonicalToStoreServiceCreateRequest extends
		AbstractMessageTransformer {

	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding)
			throws TransformerException {
		
		
		// see successful sample SOAP request to create a new Store
		
		List<Store> storeObj = ((PartnerProfile) message.getPayload()).getCompany().getCpDivision().get(0).getStores();
		// check list size
		// iterate through list
		
		CustomerServiceCreateRequest req = new CustomerServiceCreateRequest();
	
		//child object
		AxdEntityCustTable bhnStoreTable1 = new AxdEntityCustTable();
		
		//parent object
		AxdCustomer storeTable = new AxdCustomer();
		// storeTable is a List<AxdEntityCustTable>
		
		//XML Attribute required
		bhnStoreTable1.setClazz("entity");
				
		// List of fields to map
//		private	String	companyPhysicalStoreAddressLine1;
//		private	String	companyPhysicalStoreCountry;
//		private	String	productLanguage;
//		private	Boolean	storeBlocked;
//		private	String	storeBHNCustLevel;
//		private	String	storeBHNStoreCode;
//		private	String	storeChannelDimension;
//		private	String	storeContactPhoneNumber;
//		private	String	storeCountryRegionId;
//		private	String	storeCustGroup;
//		private	String	storeDimensionPAC;
//		private	String	storeDimensionRegion;
//		private	String	storePhysicalStoreAddressLine1;
//		private	String	storePhysicalStoreAddressLine2;
//		private	String	storePhysicalStoreCity;
//		private	String	storePhysicalStoreName;
//		private	String	storePhysicalStorePostalCode;
//		private	String	storePhysicalStoreState;
//		private	String	storePriceToleranceGroup;
		
		// TODO: replace the get(0) by get(ii) while iterating
		bhnStoreTable1.setAddress(storeObj.get(0).getStorePhysicalStoreAddressLine1() + " " + storeObj.get(0).getStorePhysicalStoreAddressLine2());
		//companyPhysicalStoreCountry ??
		bhnStoreTable1.setLanguageId(storeObj.get(0).getProductLanguage());
		bhnStoreTable1.setBlocked(storeObj.get(0).getStoreBlocked()==false? AxdExtTypeCustBlocked.NO:AxdExtTypeCustBlocked.INVOICE );
		bhnStoreTable1.setBhnCustLevel(storeObj.get(0).getStoreBHNCustLevel()==null? AxdExtTypeBhnCustomerLevel.NO_LEVEL:AxdExtTypeBhnCustomerLevel.STORE);
		bhnStoreTable1.setBhnStoreCode(storeObj.get(0).getStoreBHNStoreCode());
		//storeChannelDimension ??
		bhnStoreTable1.setPhone(storeObj.get(0).getStoreContactPhoneNumber());
		bhnStoreTable1.setCountryRegionId(storeObj.get(0).getCompanyPhysicalStoreCountry());
		//storeCustGroup ??
		// TODO: fix issue below
		//bhnStoreTable1.setDimension(storeObj.get(0).getStoreChannelDimension());		// AxdArrayAxdExtTypeDimension
		// storeDimensionRegion ??
		bhnStoreTable1.setCity(storeObj.get(0).getStorePhysicalStoreCity());
		// storePhysicalStoreName ??
		bhnStoreTable1.setName(storeObj.get(0).getStorePhysicalStoreName());
		bhnStoreTable1.setZipCode(storeObj.get(0).getStorePhysicalStorePostalCode());
		bhnStoreTable1.setState(storeObj.get(0).getStorePhysicalStoreState());
		bhnStoreTable1.setProjPriceGroup(storeObj.get(0).getStorePriceToleranceGroup());
		
		
		


		 
		storeTable.getCustTable().add(bhnStoreTable1);
		req.setCustomer(storeTable);
		
		return req;
	}
}