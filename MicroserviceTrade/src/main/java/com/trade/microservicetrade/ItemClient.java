package com.trade.microservicetrade;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "MICORITEM-S")
public interface ItemClient {
    @GetMapping("/")
    List<Item> getAllItems();
}
