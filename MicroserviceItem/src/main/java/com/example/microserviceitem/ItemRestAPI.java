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
    public ResponseEntity<Item> createJob(@RequestBody Item item) {
        return new ResponseEntity<>(itemService.AddItem(item), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Item> updateJob(@PathVariable(value = "id") int id,
                                         @RequestBody Item item) {
        return new ResponseEntity<>(itemService.updateItem(id, item),
                HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteJob(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(itemService.deleteItem(id), HttpStatus.OK);
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Item>> getJob() {
        List<Item> candidat = itemService.getAllItem();
        if (candidat != null) {
            return new ResponseEntity<>(candidat, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
