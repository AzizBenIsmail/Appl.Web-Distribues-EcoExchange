package com.example.microserviceorganisation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients("com.example.microserviceorganisation")
public class MicroserviceOrganisationApplication {

	@Value("${user.service.url}")
	private String userServiceUrl;
	public static void main(String[] args) {
		SpringApplication.run(MicroserviceOrganisationApplication.class, args);
	}

	@Bean
	public WebClient webClient(){
		WebClient webClient=WebClient.builder().baseUrl(userServiceUrl).build();
		return webClient;
	}
}
