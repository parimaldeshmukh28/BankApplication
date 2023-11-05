package com.banking.bankApplication.model;

import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;

@Validated
public class CustomerPatchRequest {
	
	@NonNull
	private int cid;
	
	@NonNull
	private String address;
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
