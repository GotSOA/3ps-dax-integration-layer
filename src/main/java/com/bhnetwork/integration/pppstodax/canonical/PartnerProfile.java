package com.bhnetwork.integration.pppstodax.canonical;

import java.io.Serializable;

public class PartnerProfile implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Company company;
	private Vendor vendor;
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public Vendor getVendor() {
		return vendor;
	}
	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}
	
}
