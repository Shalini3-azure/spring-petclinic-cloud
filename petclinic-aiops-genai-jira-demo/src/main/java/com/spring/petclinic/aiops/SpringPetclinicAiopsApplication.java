package com.spring.petclinic.aiops;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringPetclinicAiopsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringPetclinicAiopsApplication.class, args);
	}

}
