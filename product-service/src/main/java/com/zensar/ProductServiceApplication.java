package com.zensar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.configuration.ConfigClientApplication;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@RestController
public class ProductServiceApplication {

	@Autowired
	private ConfigClientApplication config;

	@Value("${some.other.properties}")
	private String someOtherProperty;

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	@GetMapping("/config")
	public String getConfiguration() {

		StringBuffer sb = new StringBuffer();

		sb.append(someOtherProperty);

		sb.append(" || ");

		sb.append(config.getProperties());

		return sb.toString();
	}

	/*
	 * @Bean public RestTemplate restTemplate() { return new RestTemplate(); }
	 */

}
