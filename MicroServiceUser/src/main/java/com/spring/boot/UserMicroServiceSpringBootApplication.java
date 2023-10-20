package com.spring.boot;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableAspectJAutoProxy
@EnableScheduling
//@EnableSwagger2
@SpringBootApplication
@EnableEurekaClient
public class UserMicroServiceSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserMicroServiceSpringBootApplication.class, args);
	}

}
