package com.example.eureka_server_ecoexchange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerEcoExchangeApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerEcoExchangeApplication.class, args);
    }

}
