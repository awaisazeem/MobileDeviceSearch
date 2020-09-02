package com.axiom.MobileDeviceSearch.model;

public class SearchQuery {
	
	private String id;
	private String brand;
	private String phone;
	private String picture;
	private String priceEur;
	private String announceDate;
	private String sim;
	private String resolution;
	private String audioJack;
	private String gps;
	private String battery;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getPriceEur() {
		return priceEur;
	}
	public void setPriceEur(String priceEur) {
		this.priceEur = priceEur;
	}
	public String getSim() {
		return sim;
	}
	public void setSim(String sim) {
		this.sim = sim;
	}
	public String getResolution() {
		return resolution;
	}
	public void setResolution(String resolution) {
		this.resolution = resolution;
	}
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
	public String getAnnounceDate() {
		return announceDate;
	}
	public void setAnnounceDate(String announceDate) {
		this.announceDate = announceDate;
	}
	@Override
	public String toString() {
		return "SearchQuery [id=" + id + ", brand=" + brand + ", phone=" + phone + ", picture=" + picture
				+ ", priceEur=" + priceEur + ", announceDate=" + announceDate + ", sim=" + sim + ", resolution="
				+ resolution + ", audioJack=" + audioJack + ", gps=" + gps + ", battery=" + battery + ", getId()="
				+ getId() + ", getBrand()=" + getBrand() + ", getPhone()=" + getPhone() + ", getPicture()="
				+ getPicture() + ", getPriceEur()=" + getPriceEur() + ", getSim()=" + getSim() + ", getResolution()="
				+ getResolution() + ", getAudioJack()=" + getAudioJack() + ", getGps()=" + getGps() + ", getBattery()="
				+ getBattery() + ", getAnnounceDate()=" + getAnnounceDate() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
	

}
