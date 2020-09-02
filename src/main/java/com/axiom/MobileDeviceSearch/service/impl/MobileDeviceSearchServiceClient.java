package com.axiom.MobileDeviceSearch.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.axiom.MobileDeviceSearch.constants.Constants;
import com.axiom.MobileDeviceSearch.model.MobileDevice;

@Service
public class MobileDeviceSearchServiceClient {
	
	Logger logger = LoggerFactory.getLogger(MobileDeviceSearchServiceImpl.class);

	/**
	 * restTemplate
	 */
	@Autowired
	private RestTemplate restTemplate;
	
	/**
	 * wsUrl
	 */
	@Value("${ws.url.aDefaultUrl}")
	private String wsUrl;
	
	
	/**
	 * @return List<MobileDevice>
	 */
	@Cacheable(Constants.MOBILE_DEVICE_CACHE_NAME)
	public List<MobileDevice> getDevices(){
		logger.info("Getting Devices from remote Server.");
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
		messageConverters.add(converter);
		restTemplate.setMessageConverters(messageConverters);
		logger.info("Calling Rest API to get the Mobile records.");
		ResponseEntity<List<MobileDevice>> responseEntity = restTemplate.exchange(wsUrl, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<MobileDevice>>() {
				});
		return  responseEntity.getBody();
		
	}


}
