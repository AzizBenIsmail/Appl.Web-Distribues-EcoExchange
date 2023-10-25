package com.example.microserviceorganisation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@SpringBootApplication
public class MicroserviceOrganisationApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceOrganisationApplication.class, args);
	}

}
