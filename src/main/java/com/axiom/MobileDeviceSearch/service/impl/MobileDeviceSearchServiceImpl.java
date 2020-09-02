package com.axiom.MobileDeviceSearch.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	/**
	 * logger
	 */
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
	 *input searchQuery
	 *return filteredMobileRecords
	 */
	@Override
	public List<MobileDevice> searchMobileDevices(SearchQuery searchQuery) {
		logger.info("Getting Complete list of Devices");
		Stream<MobileDevice> mobileDeviceStream = getDevices().parallelStream();
		
		if (!StringUtils.isEmpty(searchQuery.getSim())) {
			logger.info("Running Filter based on getSim..{}",searchQuery.getSim());
			mobileDeviceStream = mobileDeviceStream.filter(handsetData -> {
				String sims[] = handsetData.getSim().split(" ");
				for (String s : sims) {
					if (s.equalsIgnoreCase(searchQuery.getSim())) {
						return true;
					}
				}
				return false;
			});
		}
		
		if (!StringUtils.isEmpty(searchQuery.getAnnounceDate())) {
			logger.info("Running Filter based on getAnnounceDate..{}",searchQuery.getAnnounceDate());
			mobileDeviceStream = mobileDeviceStream.filter(
					handsetData -> handsetData.getRelease().getAnnounceDate().equalsIgnoreCase(searchQuery.getAnnounceDate()));
		}
		if (!StringUtils.isEmpty(searchQuery.getPriceEur())) {
			logger.info("Running Filter based on getPriceEur..{}",searchQuery.getPriceEur());
			mobileDeviceStream = mobileDeviceStream.filter(
					handsetData -> handsetData.getRelease().getPriceEur().equalsIgnoreCase(searchQuery.getPriceEur()));
		}

		if (!StringUtils.isEmpty(searchQuery.getId())) {
			logger.info("Running Filter based on getId..{}",searchQuery.getId());
			mobileDeviceStream = mobileDeviceStream
					.filter(handsetData -> handsetData.getId().equalsIgnoreCase(searchQuery.getId()));
		}
		if (!StringUtils.isEmpty(searchQuery.getAudioJack())) {
			logger.info("Running Filter based on getAudioJack..{}",searchQuery.getAudioJack());
			mobileDeviceStream = mobileDeviceStream
					.filter(handsetData -> handsetData.getHardware().getAudioJack().equalsIgnoreCase(searchQuery.getAudioJack()));
		}
		if (!StringUtils.isEmpty(searchQuery.getBattery())) {
			logger.info("Running Filter based on getBattery..{}",searchQuery.getBattery());
			mobileDeviceStream = mobileDeviceStream
					.filter(handsetData -> handsetData.getHardware().getBattery().equalsIgnoreCase(searchQuery.getBattery()));
		}
		if (!StringUtils.isEmpty(searchQuery.getGps())) {
			logger.info("Running Filter based on getGps..{}",searchQuery.getGps());
			mobileDeviceStream = mobileDeviceStream
					.filter(handsetData -> handsetData.getHardware().getGps().equalsIgnoreCase(searchQuery.getGps()));
		}
		if (!StringUtils.isEmpty(searchQuery.getBrand())) {
			logger.info("Running Filter based on getBrand..{}",searchQuery.getBrand());
			mobileDeviceStream = mobileDeviceStream
					.filter(handsetData -> handsetData.getBrand().equalsIgnoreCase(searchQuery.getBrand()));
		}
		if (!StringUtils.isEmpty(searchQuery.getPhone())) {
			logger.info("Running Filter based on getPhone..{}",searchQuery.getPhone());
			mobileDeviceStream = mobileDeviceStream
					.filter(handsetData -> handsetData.getPhone().equalsIgnoreCase(searchQuery.getPhone()));
		}
		if (!StringUtils.isEmpty(searchQuery.getPicture())) {
			logger.info("Running Filter based on getPicture..{}",searchQuery.getPicture());
			mobileDeviceStream = mobileDeviceStream
					.filter(handsetData -> handsetData.getPicture().equalsIgnoreCase(searchQuery.getPicture()));
		}
		if (!StringUtils.isEmpty(searchQuery.getResolution())) {
			logger.info("Running Filter based on getResolution..{}",searchQuery.getResolution());
			mobileDeviceStream = mobileDeviceStream
					.filter(handsetData -> handsetData.getResolution().equals(searchQuery.getResolution()));
		}
		
		
		List<MobileDevice> filteredMobileRecords = mobileDeviceStream.collect(Collectors.toList());
		logger.info("Filter Completed Successfully");

		return filteredMobileRecords;
	}
	
	/**
	 * @return List<MobileDevice>
	 */
	private List<MobileDevice> getDevices(){
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
