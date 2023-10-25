package com.esprit.posts.posts;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients("com.esprit.posts.posts")
public class PostsApplication {

	@Value("${user.service.url}")
	private String userServiceUrl;

	public static void main(String[] args) {
		SpringApplication.run(PostsApplication.class, args);
	}

	@Bean
	public WebClient webClient(){
		WebClient webClient=WebClient.builder().baseUrl(userServiceUrl).build();
		return webClient;
	}
}
