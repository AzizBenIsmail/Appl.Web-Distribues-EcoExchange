package com.trade.microservicetrade;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "USER-SERVICE" , path = "/user")
public interface UserClient {
    @GetMapping("/{id}")
    public User getById(@PathVariable Long id);
    @GetMapping("/users")
    public List<User>  getAllUsers();

    @PostMapping("/add")
    public User addUser(@RequestBody User user);
}
