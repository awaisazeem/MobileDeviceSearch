package com.axiom.MobileDeviceSearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.axiom.MobileDeviceSearch.constants.Constants;


@SpringBootApplication
@EnableCaching
public class MobileDeviceSearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(MobileDeviceSearchApplication.class, args);
	}
	

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
       return builder.build();
    }
    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager(Constants.MOBILE_DEVICE_CACHE_NAME);
    }

}
