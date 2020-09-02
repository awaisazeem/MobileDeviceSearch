package com.axiom.MobileDeviceSearch.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.axiom.MobileDeviceSearch.model.MobileDevice;
import com.axiom.MobileDeviceSearch.model.SearchQuery;

@Service
public interface MobileDeviceSearchService {
	
	List<MobileDevice>searchMobileDevices(SearchQuery seacrhQuery);

}
