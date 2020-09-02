package com.axiom.MobileDeviceSearch;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.axiom.MobileDeviceSearch.model.MobileDevice;
import com.axiom.MobileDeviceSearch.model.SearchQuery;
import com.axiom.MobileDeviceSearch.service.MobileDeviceSearchService;

@SpringBootTest
class MobileDeviceSearchApplicationTests {

	@Autowired
	MobileDeviceSearchService mobileDeviceService;
	
	@Test
	public void testSearchMobileDevicesByPriceEur() {

        SearchQuery query = new SearchQuery();
		query.setPriceEur("200");
        List<MobileDevice> result = mobileDeviceService.searchMobileDevices(query);

		assertEquals(10, result.size());
	}
	
	@Test
	public void testsearchMobileDevicesBySIM() {

		SearchQuery query = new SearchQuery();
		query.setSim("eSim");
        List<MobileDevice> result = mobileDeviceService.searchMobileDevices(query);

		assertEquals(18, result.size());

	}
	@Test
	public void testSearchMobileRecordsByAnnounceDateAndPrice() {

		SearchQuery query = new SearchQuery();
		query.setAnnounceDate("1999");
		query.setPriceEur("200");
        List<MobileDevice> result = mobileDeviceService.searchMobileDevices(query);

		assertEquals(2, result.size());

	}
	
	

	

	


}
