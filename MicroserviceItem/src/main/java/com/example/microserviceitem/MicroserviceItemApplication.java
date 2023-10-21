package com.example.microserviceitem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class MicroserviceItemApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceItemApplication.class, args);
    }
    @Autowired
    private ItemRepository itemRepository;

    @Bean
    ApplicationRunner init(){
        return (args)-> {
            //Save
            itemRepository.save(new Item("Aziz","Is","esprit","good"));
            itemRepository.save(new Item("Ahmed","Is","esp","good"));
            itemRepository.save(new Item("Hamza","Is","eit","good"));
            //fetch
            itemRepository.findAll().forEach(System.out::println);
        };
    }
}
