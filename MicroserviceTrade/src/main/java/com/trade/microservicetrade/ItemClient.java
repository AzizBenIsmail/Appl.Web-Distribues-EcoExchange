package com.trade.microservicetrade;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "MICORITEM-S")
public interface ItemClient {
    @GetMapping("/")
    public List<Item> getAllItems();
    @GetMapping("/items/{id}")
    public  Item getItemById (@PathVariable long id);

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Item> createItem(@RequestBody Item item);
}
