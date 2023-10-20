package com.spring.boot;
/*
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

//@Configuration
public class SwaggerConfig {
	
	//learn more about path selector
	@Bean
	public Docket api() {
	return new Docket(DocumentationType.SWAGGER_2)
												.select()
												.apis(RequestHandlerSelectors.basePackage("com.spring.boot"))
												.paths(PathSelectors.any())
												.build().apiInfo(apiInfo());
	}
	
	
	
	private ApiInfo apiInfo () {
	return new ApiInfoBuilder()
								.title("Swagger API Documentation For UserMicroService-Spring-Boot Project")
								.termsOfServiceUrl("")
								.description("\"I hope you find the documentation usefull :) \"")
					            .contact(new Contact("Created By Elyes Boudhina","www.linkedin.com/in/elyes-boudhina","elyes.boudhina@esprit.tn"))
								.version("1.1.0").build();
	}
}
*/