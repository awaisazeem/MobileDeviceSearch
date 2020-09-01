package com.axiom.MobileDeviceSearch.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.axiom.MobileDeviceSearch.model.MobileDevice;

@RestController
@RequestMapping("/mobile")
public class MobileDeviceSearchController {
	
	@GetMapping("/search")
	public List<MobileDevice> getMobileDevice(@RequestParam(name = "id",required = false) String id,@RequestParam(name ="brand",required = false) String brand,
			@RequestParam(name ="phone" ,required = false) String phone,@RequestParam(name ="picture",required = false) String picture,
			@RequestParam(name="announceDate",required = false) String announceDate,@RequestParam(name="priceEur",required = false) String priceEur,
			@RequestParam(name="sim",required = false) String sim,@RequestParam(name="resolution",required = false) String resolution,
			@RequestParam(name="audioJack",required = false) String audioJack,@RequestParam(name="gps",required = false) String gps,
			@RequestParam(name="gps",required = false) String battery) {
				
		List<MobileDevice> dto = new ArrayList<MobileDevice>();
		MobileDevice mobileDTO = new MobileDevice();
		mobileDTO.setBrand("Vivo");
		dto.add(mobileDTO);
		
		return dto;
		
		
	}

}
