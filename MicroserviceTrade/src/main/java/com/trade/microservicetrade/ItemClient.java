package com.trade.microservicetrade;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "MICROITEM", url = "http://localhost:8055", path = "/MicroserviceItem")
public interface ItemClient {
}
