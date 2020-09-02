package com.axiom.MobileDeviceSearch.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.axiom.MobileDeviceSearch.model.MobileDevice;
import com.axiom.MobileDeviceSearch.model.SearchQuery;
import com.axiom.MobileDeviceSearch.service.MobileDeviceSearchService;

@Service
public class MobileDeviceSearchServiceImpl implements MobileDeviceSearchService {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${ws.url.aDefaultUrl}")
	private String wsUrl;

	@Override
	public List<MobileDevice> searchMobileDevices(SearchQuery searchQuery) {
	
		Stream<MobileDevice> handsetDataStream = getDevices().parallelStream();

		if (!StringUtils.isEmpty(searchQuery.getSim())) {
			handsetDataStream = handsetDataStream.filter(handsetData -> {
				if (handsetData.getSim().equalsIgnoreCase(searchQuery.getSim())) {
					return true;
				}

				return false;
			});
		}
		if (!StringUtils.isEmpty(searchQuery.getAnnounceDate())) {
			handsetDataStream = handsetDataStream.filter(
					handsetData -> handsetData.getRelease().getAnnounceDate().equalsIgnoreCase(searchQuery.getAnnounceDate()));
		}
		if (!StringUtils.isEmpty(searchQuery.getPriceEur())) {
			handsetDataStream = handsetDataStream.filter(
					handsetData -> handsetData.getRelease().getPriceEur().equalsIgnoreCase(searchQuery.getPriceEur()));
		}

		if (!StringUtils.isEmpty(searchQuery.getId())) {
			handsetDataStream = handsetDataStream
					.filter(handsetData -> handsetData.getId().equalsIgnoreCase(searchQuery.getId()));
		}
		if (!StringUtils.isEmpty(searchQuery.getAudioJack())) {
			handsetDataStream = handsetDataStream
					.filter(handsetData -> handsetData.getHardware().getAudioJack().equalsIgnoreCase(searchQuery.getAudioJack()));
		}
		if (!StringUtils.isEmpty(searchQuery.getBattery())) {
			handsetDataStream = handsetDataStream
					.filter(handsetData -> handsetData.getHardware().getBattery().equalsIgnoreCase(searchQuery.getBattery()));
		}
		if (!StringUtils.isEmpty(searchQuery.getGps())) {
			handsetDataStream = handsetDataStream
					.filter(handsetData -> handsetData.getHardware().getGps().equalsIgnoreCase(searchQuery.getGps()));
		}
		if (!StringUtils.isEmpty(searchQuery.getBrand())) {
			handsetDataStream = handsetDataStream
					.filter(handsetData -> handsetData.getBrand().equalsIgnoreCase(searchQuery.getBrand()));
		}
		if (!StringUtils.isEmpty(searchQuery.getPhone())) {
			handsetDataStream = handsetDataStream
					.filter(handsetData -> handsetData.getPhone().equalsIgnoreCase(searchQuery.getPhone()));
		}
		if (!StringUtils.isEmpty(searchQuery.getPicture())) {
			handsetDataStream = handsetDataStream
					.filter(handsetData -> handsetData.getPicture().equalsIgnoreCase(searchQuery.getPicture()));
		}
		if (!StringUtils.isEmpty(searchQuery.getResolution())) {
			handsetDataStream = handsetDataStream
					.filter(handsetData -> handsetData.getResolution().equals(searchQuery.getResolution()));
		}
		List<MobileDevice> filteredRecords = handsetDataStream.collect(Collectors.toList());

		return filteredRecords;
	}
	
	private List<MobileDevice> getDevices(){
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
		messageConverters.add(converter);
		restTemplate.setMessageConverters(messageConverters);
		ResponseEntity<List<MobileDevice>> responseEntity = restTemplate.exchange(wsUrl, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<MobileDevice>>() {
				});
		return  responseEntity.getBody();
		
	}

}
