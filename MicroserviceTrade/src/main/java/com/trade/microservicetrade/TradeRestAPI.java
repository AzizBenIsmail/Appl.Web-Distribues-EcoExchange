package com.trade.microservicetrade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TradeRestAPI {
    @Autowired TradeService tradeService;
    @Autowired ItemClient itemClient;

    private String hello = "Hello I'm the trade MS";

    @RequestMapping("/hello")
    public String sayHello() {

        return hello;
    }
    @RequestMapping("/items")
    public List<Item> getItems() {

        List<Item> items = itemClient.getAllItems();
        return items;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Trade> createJob(@RequestBody Trade trade) {
        return new ResponseEntity<>(tradeService.AddTrade(trade), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Trade> updateJob(@PathVariable(value = "id") int id,
                                          @RequestBody Trade trade) {
        return new ResponseEntity<>(tradeService.updateTrade(id, trade),
                HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteJob(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(tradeService.deleteTrade(id), HttpStatus.OK);
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Trade>> getJob() {
        List<Trade> trades = tradeService.getAllTrade();
        if (trades != null) {
            return new ResponseEntity<>(trades, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
