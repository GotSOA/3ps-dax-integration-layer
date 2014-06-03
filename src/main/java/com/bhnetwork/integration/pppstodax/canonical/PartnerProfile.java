package com.bhnetwork.integration.pppstodax.canonical;

import java.io.Serializable;

import javax.validation.Valid;

public class PartnerProfile implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Valid
	private Company company;
	@Valid
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
