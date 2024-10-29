package com.tms.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class TravelManagementServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TravelManagementServerApplication.class, args);
		System.out.println("server up!!!...");
	}
}
