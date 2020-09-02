package com.axiom.MobileDeviceSearch.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class release {
	
	private String announceDate;
	private String priceEur;
	
	public String getAnnounceDate() {
		return announceDate;
	}
	public void setAnnounceDate(String announceDate) {
		this.announceDate = announceDate;
	}
	public String getPriceEur() {
		return priceEur;
	}
	public void setPriceEur(String priceEur) {
		this.priceEur = priceEur;
	}
	
	

}
