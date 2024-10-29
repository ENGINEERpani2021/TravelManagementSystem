package com.tms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.tms")
@EnableDiscoveryClient
@EntityScan(basePackages = "com.tms.entity")
@EnableJpaRepositories(basePackages = "com.tms.repository")
public class TravelManagementSoftwareApplication {

	public static void main(String[] args) {
		SpringApplication.run(TravelManagementSoftwareApplication.class, args);
	}
}
