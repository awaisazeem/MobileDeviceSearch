package com.axiom.MobileDeviceSearch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.axiom.MobileDeviceSearch.model.MobileDevice;
import com.axiom.MobileDeviceSearch.model.SearchQuery;
import com.axiom.MobileDeviceSearch.service.MobileDeviceSearchService;

@RestController
@RequestMapping("/mobile")
public class MobileDeviceSearchController {
	
	@Autowired
	private MobileDeviceSearchService mobileDeviceSearch;
	
	@GetMapping("/search")
	public List<MobileDevice> getMobileDevice(
			@RequestParam(name = "id",required = false) String id,@RequestParam(name ="brand",required = false) String brand,
			@RequestParam(name ="phone" ,required = false) String phone,@RequestParam(name ="picture",required = false) String picture,
			@RequestParam(name="announceDate",required = false) String announceDate,@RequestParam(name="priceEur",required = false) String priceEur,
			@RequestParam(name="sim",required = false) String sim,@RequestParam(name="resolution",required = false) String resolution,
			@RequestParam(name="audioJack",required = false) String audioJack,@RequestParam(name="gps",required = false) String gps,
			@RequestParam(name="battery",required = false) String battery) {
		SearchQuery seacrhQuery = new SearchQuery();
		seacrhQuery.setId(id);
		seacrhQuery.setAudioJack(audioJack);
		seacrhQuery.setBattery(battery);
		seacrhQuery.setBrand(brand);
		seacrhQuery.setGps(gps);
		seacrhQuery.setPhone(phone);
		seacrhQuery.setPicture(picture);
		seacrhQuery.setPriceEur(priceEur);
		seacrhQuery.setAnnounceDate(announceDate);
		seacrhQuery.setResolution(resolution);
		seacrhQuery.setSim(sim);
		return mobileDeviceSearch.searchMobileDevices(seacrhQuery);
		
		
	}

}
