package com.bhnetwork.integration.transformer;

import java.text.ParseException;
import java.util.List;



import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;

import com.bhnetwork.integration.pppstodax.canonical.Store;
import com.bhnetwork.integration.pppstodax.canonical.PartnerProfile;

import com.microsoft.schemas.dynamics._2008._01.documents.customer.AxdEntityCustTable;
import com.microsoft.schemas.dynamics._2008._01.documents.customer.AxdArrayAxdExtTypeDimension;
import com.microsoft.schemas.dynamics._2008._01.documents.customer.AxdCustomer;
import com.microsoft.schemas.dynamics._2008._01.documents.customer.AxdEntityAddressRelationship;
import com.microsoft.schemas.dynamics._2008._01.documents.customer.AxdEntityCustAddress;
import com.microsoft.schemas.dynamics._2008._01.documents.customer.AxdEnumDirPartyType;
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
		System.out.println("Detected " + storeObj.size() + " Store(s)");
		
		CustomerServiceCreateRequest req = new CustomerServiceCreateRequest();
	
		//parent object
		AxdCustomer customerStore = new AxdCustomer();
		// customerStore is a List<AxdEntityCustTable>
		
		// iterate through list
		for (Store curStore : storeObj) {
		
			//child object
			AxdEntityCustTable bhncustomerStoreTable1 = new AxdEntityCustTable();
		
			//XML Attribute required
			bhncustomerStoreTable1.setClazz("entity");
					
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
			bhncustomerStoreTable1.setAddress(curStore.getStorePhysicalStoreAddressLine1() + " " + curStore.getStorePhysicalStoreAddressLine2());
			//companyPhysicalStoreCountry ??
			bhncustomerStoreTable1.setLanguageId(curStore.getProductLanguage());
			bhncustomerStoreTable1.setBlocked(curStore.getStoreBlocked()==false? AxdExtTypeCustBlocked.NO:AxdExtTypeCustBlocked.INVOICE );
			// issue when setting these 2
			//bhncustomerStoreTable1.setBhnCompanyCode("foobar");
			//bhncustomerStoreTable1.setBhnDivisionCode("123");
			
			bhncustomerStoreTable1.setBhnCustLevel(curStore.getStoreBHNCustLevel()==null? AxdExtTypeBhnCustomerLevel.NO_LEVEL:AxdExtTypeBhnCustomerLevel.STORE);
			bhncustomerStoreTable1.setBhnStoreCode(curStore.getStoreBHNStoreCode());
			//storeChannelDimension ??
			// Currency MISSING in JSON, for now defaulting to USD
			bhncustomerStoreTable1.setCurrency("USD");
			// CustGroup MISSING in JSON
			bhncustomerStoreTable1.setCustGroup(curStore.getStoreCustGroup());
			// bhncustomerStoreTable1.setCustItemGroupId(null);
			// TODO: PartyType MISSING in canonical
			// bhncustomerStoreTable1.setPartyType(isnull(curStore.getPartyType())? AxdEnumDirPartyType.PERSON:AxdEnumDirPartyType.ORGANIZATION);
			bhncustomerStoreTable1.setPartyType(AxdEnumDirPartyType.PERSON);   // temporary HACK
			bhncustomerStoreTable1.setPaymDayId(null);
			bhncustomerStoreTable1.setPhone(curStore.getStoreContactPhoneNumber());
			bhncustomerStoreTable1.setCountryRegionId(curStore.getCompanyPhysicalStoreCountry());
			//storeCustGroup ??
			// TODO: fix issue below
			//bhnStoreTable1.setDimension(curStore.getStoreChannelDimension());		// AxdArrayAxdExtTypeDimension
			// storeDimensionRegion ??
			bhncustomerStoreTable1.setCity(curStore.getStorePhysicalStoreCity());
			// storePhysicalStoreName ??
			bhncustomerStoreTable1.setName(curStore.getStorePhysicalStoreName());
			bhncustomerStoreTable1.setZipCode(curStore.getStorePhysicalStorePostalCode());
			bhncustomerStoreTable1.setState(curStore.getStorePhysicalStoreState());
			bhncustomerStoreTable1.setProjPriceGroup(curStore.getStorePriceToleranceGroup());
					 
			customerStore.getCustTable().add(bhncustomerStoreTable1);
			req.setCustomer(customerStore);
		} // end for loop
		return req;
	}
}