package com.axiom.MobileDeviceSearch.model;

public class MobileDevice {
	
	private String id;
	private String brand;
	private String phone;
    private String picture;
    private release release;
    private String sim;
    private String resolution;
    private hardware hardware;
	
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
	public release getRelease() {
		return release;
	}
	public void setRelease(release release) {
		this.release = release;
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
	public hardware getHardware() {
		return hardware;
	}
	public void setHardware(hardware hardware) {
		this.hardware = hardware;
	}
    
    
}
