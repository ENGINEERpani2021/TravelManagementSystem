package com.bms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = "com.bms")
@EnableDiscoveryClient
@EntityScan(basePackages = "com.bms.entity")
@EnableJpaRepositories(basePackages = "com.bms.repository")
public class BookingManagementSoftwareApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingManagementSoftwareApplication.class, args);
		System.out.println("BMS client server up.......");
	}
	@Bean
	public RestTemplate templateGenereator() {
		return new RestTemplate();
	}
}
