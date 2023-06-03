package com.spring_boot_jedi_universe.microservices.jedi_discovery_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class JediDiscoveryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(JediDiscoveryServiceApplication.class, args);
	}

}
