package com.tsaksia.dealer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan("com.tsaksia.dealer.server")
public class DealerApplication {

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "dealer-server");
		SpringApplication.run(DealerApplication.class, args);
	}
}
