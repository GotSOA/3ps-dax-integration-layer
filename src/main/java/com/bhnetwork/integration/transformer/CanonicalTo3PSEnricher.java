package com.bhnetwork.integration.transformer;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.api.transport.PropertyScope;
import org.mule.transformer.AbstractMessageTransformer;

import com.bhnetwork.integration.pppstodax.canonical.PartnerProfile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class CanonicalTo3PSEnricher extends
		AbstractMessageTransformer {

	@SuppressWarnings("unchecked")
	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding)
			throws TransformerException {
		
		// payload contains the 3PS GET payload that was converted from json java.util.LinkedHashMap
		@SuppressWarnings("rawtypes")
		LinkedHashMap enrichedPartnerProfileHashMap = (LinkedHashMap) message.getPayload();
		
		// canon is in session
		PartnerProfile canonPartnerProfile = (PartnerProfile) message.getProperty("canon", PropertyScope.SESSION);
		
		// company entity
		if (enrichedPartnerProfileHashMap.containsKey("company")) {
			// type cast doesn't work
			@SuppressWarnings("rawtypes")
			LinkedHashMap companyHashMap = (LinkedHashMap) enrichedPartnerProfileHashMap.get("company");
			// log before
			//System.out.println("(3PS GET) company.bhnGUID: " + companyHashMap.get("companyBHNGUID"));
			//System.out.println("(3PS GET) company.recId: " + companyHashMap.get("companyRecId"));
			
			// enrich (3PS) company with BhnGUID and RecId from (Canon) company 
			companyHashMap.put("companyBHNGUID", canonPartnerProfile.getCompany().getBhnGUID());
			companyHashMap.put("companyRecId", canonPartnerProfile.getCompany().getRecId());
			
			// log after
			//System.out.println("(ENRICHED) company.bhnGUID: " + companyHashMap.get("companyBHNGUID"));
			//System.out.println("(ENRICHED) company.recId: " + companyHashMap.get("companyRecId"));

			// company entity stands by itself so it's fine to do the enriching now
			enrichedPartnerProfileHashMap.put("company", companyHashMap);			
		}
			else
			System.out.println("ERROR retrieving key 'company' from 3PS GET Payload");
		
		
		// division entity
		if (enrichedPartnerProfileHashMap.containsKey("cpDivision")) {
			@SuppressWarnings("rawtypes")
			LinkedHashMap divisionHashMap = (LinkedHashMap) enrichedPartnerProfileHashMap.get("cpDivision");
			// log before
			//System.out.println("(3PS GET) cpDivision.bhnGUID: " + divisionHashMap.get("divisionBhnGUID"));
			//System.out.println("(3PS GET) cpDivision.recId: " + divisionHashMap.get("divisionRecId"));
			
			// enrich (3PS) cpDivision with BhnGUID and RecId from (Canon) division
			divisionHashMap.put("divisionBhnGUID", canonPartnerProfile.getCompany().getCpDivision().get(0).getBhnGUID());
			divisionHashMap.put("divisionRecId",canonPartnerProfile.getCompany().getCpDivision().get(0).getRecId());
			
			// log after
			//System.out.println("(3PS ENRICHED) cpDivision.bhnGUID: " + divisionHashMap.get("divisionBhnGUID"));
			//System.out.println("(3PS ENRICHED) cpDivision.recId: " + divisionHashMap.get("divisionRecId"));

			// wait for enriching, because other entities are nested inside cpDivision
			
			// iterate through cpDivision
		    @SuppressWarnings("rawtypes")
			Iterator iterator = divisionHashMap.keySet().iterator();
			  while (iterator.hasNext()) {
				  String key = (String) iterator.next();
				  
				  // stores
				  // look for keys: divisionCustomerStores (java.util.ArrayList) & divisionProducts (java.util.ArrayList)
				  // and ignore other keys
				  if (key.equalsIgnoreCase("divisionCustomerStores")) {
					  ArrayList<HashMap<String, Object>> storeList = (ArrayList<HashMap<String, Object>>) divisionHashMap.get("divisionCustomerStores");
					  //System.out.println("(INSIDE DIVISION) store list size: " + storeList.size());
				      int i = 0;
				      while (i < storeList.size()) {
				    	    //System.out.println("Store[" + i + "]: " +  storeList.get(i).get("storePhysicalStoreName"));
							storeList.get(i).put("storeAccountNum", canonPartnerProfile.getCompany().getCpDivision().get(0).getStores().get(i).getAccountNum());
							storeList.get(i).put("bhnCompanyCode", canonPartnerProfile.getCompany().getCpDivision().get(0).getStores().get(i).getBhnCompanyCode());
							storeList.get(i).put("bhnDivisionCode", canonPartnerProfile.getCompany().getCpDivision().get(0).getStores().get(i).getBhnDivisionCode());
							storeList.get(i).put("bhnGUID", canonPartnerProfile.getCompany().getCpDivision().get(0).getStores().get(i).getBhnGUID());
				            i++;
				      }
				  }
				  
				  if (key.equalsIgnoreCase("divisionProducts")) {
					  ArrayList<HashMap<String, Object>> productList = (ArrayList<HashMap<String, Object>>) divisionHashMap.get("divisionProducts");
					  //System.out.println("(INSIDE DIVISION) product list size: " + productList.size());
				      int i = 0;
				      while (i < productList.size()) {
				    	    //System.out.println("Product[" + i + "]: " +  productList.get(i).get("productItemName"));
						  	productList.get(i).put("productBHNGUID", canonPartnerProfile.getCompany().getCpDivision().get(0).getProducts().get(i).getBhnGUID());
						  
						  	// 5 for iid (they are nested inside product
							if (productList.get(i).containsKey("iid")) {
								@SuppressWarnings("rawtypes")
								LinkedHashMap iidHashMap = (LinkedHashMap) productList.get(i).get("iid");
								iidHashMap.put("itemId", canonPartnerProfile.getCompany().getCpDivision().get(0).getProducts().get(i).getIid().getItemId());
								iidHashMap.put("IID", canonPartnerProfile.getCompany().getCpDivision().get(0).getProducts().get(i).getIid().getInventBatchId());
								iidHashMap.put("bhnGUID", canonPartnerProfile.getCompany().getCpDivision().get(0).getProducts().get(i).getIid().getBhnGUID());
								iidHashMap.put("RecId", canonPartnerProfile.getCompany().getCpDivision().get(0).getProducts().get(i).getIid().getRecId());
							}
							else
								System.out.println("ERROR retrieving key 'cpDivision' from 3PS GET Payload");
							
							// and 4 for substitutionGrp
							productList.get(i).put("subGroupId", canonPartnerProfile.getCompany().getCpDivision().get(0).getProducts().get(i).getSubstGrp().getSubGroupId());
							productList.get(i).put("substitutionBrandDenomDescription", canonPartnerProfile.getCompany().getCpDivision().get(0).getProducts().get(i).getSubstGrp().getSubstitutionBrandDenomDescription());
							productList.get(i).put("guid", canonPartnerProfile.getCompany().getCpDivision().get(0).getProducts().get(i).getSubstGrp().getGuid());
							productList.get(i).put("brandRecId", canonPartnerProfile.getCompany().getCpDivision().get(0).getProducts().get(i).getSubstGrp().getBrandRecId());
							i++;
					  }
				  }
			  }
			
			  enrichedPartnerProfileHashMap.put("cpDivision", divisionHashMap);			
		}
			else
			System.out.println("ERROR retrieving key 'cpDivision' from 3PS GET Payload");
        
		
        // vendor entity
		if (enrichedPartnerProfileHashMap.containsKey("vendorInformation")) {
			@SuppressWarnings("rawtypes")
			LinkedHashMap vendorHashMap = (LinkedHashMap) enrichedPartnerProfileHashMap.get("vendorInformation");
			// log before
			//System.out.println("(3PS GET) vendorInformation.accountNum: " + vendorHashMap.get("vendorAccountNum"));
			//System.out.println("(3PS GET) vendorInformation.recId: " + vendorHashMap.get("vendorRecId"));
			
			// enrich (3PS) cpDivision with BhnGUID and RecId from (Canon) division
			vendorHashMap.put("vendorAccountNum", canonPartnerProfile.getCompany().getCpDivision().get(0).getBhnGUID());
			vendorHashMap.put("vendorRecId",canonPartnerProfile.getCompany().getCpDivision().get(0).getRecId());
			
			// log after
			//System.out.println("(3PS ENRICHED) vendorInformation.accountNum: " + vendorHashMap.get("vendorAccountNum"));
			//System.out.println("(3PS ENRICHED) vendorInformation.recId: " + vendorHashMap.get("vendorRecId"));

			// vendorInformation entity stands by itself so it's fine to do the enriching now
			enrichedPartnerProfileHashMap.put("vendorInformation", vendorHashMap);			
		}
			else
			System.out.println("ERROR retrieving key 'cpDivision' from 3PS GET Payload");
		
		// return enriched partner profile
		return enrichedPartnerProfileHashMap;
	}
}
