package com.bhnetwork.integration.transformer;

import java.util.List;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.api.transport.PropertyScope;
import org.mule.transformer.AbstractMessageTransformer;

import com.bhnetwork.integration.pppstodax.canonical.Division;
import com.bhnetwork.integration.pppstodax.canonical.PartnerProfile;
import com.bhnetwork.integration.pppstodax.canonical.Store;
import com.bhnetwork.integration.pppstodax.canonical.SubstitutionGroup;
import com.microsoft.schemas.dynamics._2008._01.documents.customer.AxdCustomer;
import com.microsoft.schemas.dynamics._2008._01.documents.customer.AxdEntityCustTable;
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
		
		System.out.println("=======================================================================");
		System.out.println("Number of stores in canonical: " + storeObj.size());
		System.out.println("=======================================================================");
		//int idx=0;
		// BUG in DATA MAPPER somehow doesn't happen for Stores
		
		//child object: moved it outside of the for loop
		AxdEntityCustTable bhncustomerStoreTable1 = new AxdEntityCustTable();
		
		// get canon from session to retrieve companyCode and DivisionCode
		PartnerProfile canonPartnerProfile = (PartnerProfile) message.getProperty("canon", PropertyScope.SESSION);
		
		// iterate through list
		for (Store curStore : storeObj) {
		
			//if (idx < storeObj.size()-1) {
		
					//XML Attribute required
					bhncustomerStoreTable1.setClazz("entity");
					
					// TODO: replace the get(0) by get(ii) while iterating
					bhncustomerStoreTable1.setAddress(curStore.getStorePhysicalStoreAddressLine1() + " " + curStore.getStorePhysicalStoreAddressLine2());
					
					bhncustomerStoreTable1.setLanguageId(curStore.getProductLanguage().toLowerCase());   // works with 'en-us'
					// todo: fix hardwired value
					bhncustomerStoreTable1.setLanguageId("en-us");   
					bhncustomerStoreTable1.setBlocked(curStore.getStoreBlocked()==false? AxdExtTypeCustBlocked.NO:AxdExtTypeCustBlocked.INVOICE );
					
					bhncustomerStoreTable1.setBhnCompanyCode(canonPartnerProfile.getCompany().getCompanyCode());
					bhncustomerStoreTable1.setBhnDivisionCode(canonPartnerProfile.getCompany().getCpDivision().get(0).getDivisionCode());
					
					bhncustomerStoreTable1.setBhnCustLevel(curStore.getStoreBHNCustLevel()==null? AxdExtTypeBhnCustomerLevel.NO_LEVEL:AxdExtTypeBhnCustomerLevel.STORE);
					bhncustomerStoreTable1.setBhnStoreCode(curStore.getStoreBHNStoreCode());
					//storeChannelDimension ??
					// Currency MISSING in JSON, for now defaulting to USD
					// todo: fix hardwired value
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
					// barfs if not set to blank
					bhncustomerStoreTable1.setCounty("");	// ALAMEDA
					//companyPhysicalStoreCountry: cannot pass it, not exposed

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
					
					// pass the partnerProfileId
					bhncustomerStoreTable1.setPartnerProfileId(message.getProperty("partnerProfileId", PropertyScope.SESSION).toString());
							 
					customerStore.getCustTable().add(bhncustomerStoreTable1);
			//}
			//else
			//	System.out.println("skipping final product (zombie element generated by DM)");
			//
			//idx++;	
			
			req.setCustomer(customerStore);
		} // end for loop
		return req;
	}
}