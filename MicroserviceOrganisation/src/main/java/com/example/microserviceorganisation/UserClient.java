package com.example.microserviceorganisation;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "USER-SERVICE" , path = "/user")
public interface UserClient {
    @GetMapping("/{id}")
    public UserResponse getById(@PathVariable long id);
}
