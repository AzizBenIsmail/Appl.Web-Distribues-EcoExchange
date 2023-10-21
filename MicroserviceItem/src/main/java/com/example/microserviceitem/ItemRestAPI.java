package com.example.microserviceitem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemRestAPI {

    private String hello = "Hello I'm Job";

    @RequestMapping("/hello")
    public String sayHello() {
        return hello;
    }

    @Autowired
    private ItemService itemService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Item> createitem(@RequestBody Item item) {
        return new ResponseEntity<>(itemService.AddItem(item), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Item> updateitem(@PathVariable(value = "id") int id,
                                           @RequestBody Item item) {
        return new ResponseEntity<>(itemService.updateItem(id, item),
                HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteitem(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(itemService.deleteItem(id), HttpStatus.OK);
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Item>> getitem() {
        List<Item> item = itemService.getAllItem();
        if (item != null) {
            return new ResponseEntity<>(item, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/items/{id}")
    @ResponseStatus(HttpStatus.OK)
    private ResponseEntity<Item> getItem(@PathVariable("id") int id) {
        Item item = itemService.getItemById(id);
        return ResponseEntity.status(HttpStatus.OK).body(item);
    }
}
