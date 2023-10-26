package com.example.microserviceitem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.beans.factory.annotation.Value;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients("com.example.microserviceitem")
public class MicroserviceItemApplication {
    @Value("${user.service.url}")
    private String userServiceUrl;


    public static void main(String[] args) {
        SpringApplication.run(MicroserviceItemApplication.class, args);
    }
    @Autowired
    private ItemRepository itemRepository;

    @Bean
    ApplicationRunner init(){
        return (args)-> {
            //Save
            itemRepository.save(new Item("Marto","Puissance 3A","Bricolage","Good",1));
            itemRepository.save(new Item("Ibn Khaldûn (1332-1406)","Considéré comme l'un des plus grands penseurs en Islam, Ibn Khaldoun est l'auteur d'une œuvre monumentale qui rayonnera, des siècles plus tard, bien au-delà du monde musulman","Culture","Very Good",2));
            itemRepository.save(new Item("Plante","Les plantes sont des organismes photosynthétiques et autotrophes, caractérisés par des cellules végétales. Elles forment l'un des règnes des Eukaryota. Ce règne est un groupe monophylétique comprenant les plantes terrestres","Gardiennage","Good",3));
            //fetch
            itemRepository.findAll().forEach(System.out::println);
        };
    }

    @Bean
    public WebClient webClient(){
        WebClient webClient=WebClient.builder().baseUrl(userServiceUrl).build();
        return webClient;
    }
}
