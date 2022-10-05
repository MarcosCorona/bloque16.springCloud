package com.bosonit.tripfrontend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.bosonit.tripbackend")
@EnableDiscoveryClient
public class TripFrontendApplication {

	public static void main(String[] args) {
		SpringApplication.run(TripFrontendApplication.class, args);
	}

}
