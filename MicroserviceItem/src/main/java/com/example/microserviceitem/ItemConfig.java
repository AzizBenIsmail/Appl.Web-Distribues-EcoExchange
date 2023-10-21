package com.example.microserviceitem;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ItemConfig {

    @Bean
    public ModelMapper modelMapperBean() {
        return new ModelMapper();
    }

}
