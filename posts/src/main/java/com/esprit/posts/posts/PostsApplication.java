package com.esprit.posts.posts;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
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
    ApplicationRunner init(PostRepository postRepository) {
        return args -> {
            Post post = new Post();
            post.setTitle("Post1");
            post.setContent("this is a content for a post1 for a microservice project ");
 			post.setImage_url("https://images.pexels.com/photos/417074/pexels-photo-417074.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
            post.setUser_id(1);
            post.setCreated_at("2023-10-20T12:00:00");
            post.setUpdated_at("2023-10-20T12:00:00");
            postRepository.save(post);
			Post post1 = new Post();
            post1.setTitle("Post1");
            post1.setContent("this is a content for a post11 for a microservice project ");
            post1.setImage_url("https://vastphotos.com/files/uploads/social/good-morning-new-york.jpg");
            post1.setUser_id(1);
            post1.setCreated_at("2022-10-20T12:00:00");
            post1.setUpdated_at("2022-10-20T12:00:00");
			postRepository.save(post1);
        };
    }
	@Bean
	public WebClient webClient(){
		WebClient webClient=WebClient.builder().baseUrl(userServiceUrl).build();
		return webClient;
	}
}
