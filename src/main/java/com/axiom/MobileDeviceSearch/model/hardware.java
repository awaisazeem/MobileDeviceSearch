package com.axiom.MobileDeviceSearch.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Awais Azeem
 *
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class hardware {
	
	private String audioJack;
	private String gps;
	private String battery; 
	public String getAudioJack() {
		return audioJack;
	}
	public void setAudioJack(String audioJack) {
		this.audioJack = audioJack;
	}
	public String getGps() {
		return gps;
	}
	public void setGps(String gps) {
		this.gps = gps;
	}
	public String getBattery() {
		return battery;
	}
	public void setBattery(String battery) {
		this.battery = battery;
	} 

}
