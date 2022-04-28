package com.microservice.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableHystrixDashboard

public class HystrixDashBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(HystrixDashBoardApplication.class, args);
	}

}
