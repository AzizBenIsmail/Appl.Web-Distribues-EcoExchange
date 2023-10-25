package com.example.microserviceorganisation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class MicroserviceOrganisationApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceOrganisationApplication.class, args);
	}

}
