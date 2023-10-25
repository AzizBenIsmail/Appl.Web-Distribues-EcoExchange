package com.trade.microservicetrade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TradeRestAPI {
    @Autowired
   TradeService tradeService;


    private String hello = "Hello I'm Job";

    @RequestMapping("/hello")
    public String sayHello() {
        return hello;
    }

    @PostMapping("/")
    public Trade createTrade(@RequestBody Trade trade) {
      System.out.println(trade);
        return  tradeService.createTrade(trade);
    }

    @GetMapping("/{tradeId}")
    public Trade getTradeById(@PathVariable int tradeId) {
        Trade trade = tradeService.getTradeById(tradeId);
        if (trade != null) {
            return trade;
        } else {
            return null;
        }
    }

    @GetMapping("/")
    public List<Trade> getAllTrades() {
        List<Trade> trades = tradeService.getAllTradesWithDetails();
        return trades;
    }

    @GetMapping("/users/{userId}")
    public User getUserById(@PathVariable Long userId) {
        User user = tradeService.getUserById(userId);
        if (user != null) {
            return user;
        } else {
            return null;
        }
    }

    @GetMapping("/items")
    public ResponseEntity<List<Item>> getAllItems() {
        List<Item> items = tradeService.getAllItems();
        return ResponseEntity.ok(items);
    }
    @GetMapping("/users")
    public List<User> getAllUsers() {
        List<User> users = tradeService.getAllUsers();
        return users;
    }
    @GetMapping("/items/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable int id) {
        Item item = tradeService.getItemById(id);

        if (item != null) {
            return ResponseEntity.ok(item);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{tradeId}")
    public Trade updateTrade(@PathVariable Long tradeId, @RequestBody Trade trade) {
        Trade updatedTrade = tradeService.updateTrade(tradeId,trade);
        return updatedTrade;
    }

    @DeleteMapping("/{tradeId}")
    public ResponseEntity<Void> deleteTrade(@PathVariable int tradeId) {
        tradeService.deleteTrade(tradeId);
        return ResponseEntity.noContent().build();
    }
}
