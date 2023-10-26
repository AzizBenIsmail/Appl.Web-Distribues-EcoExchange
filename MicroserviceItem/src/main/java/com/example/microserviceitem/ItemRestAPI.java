package com.example.microserviceitem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
//@RequestMapping(value = "item")
public class ItemRestAPI {

    private String hello = "Hello I'm Job";

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/hello")
    public String sayHello() {
        return hello;
    }

    @Autowired
    private ItemService itemService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Item> createitem(@RequestBody Item item) {
        return new ResponseEntity<>(itemService.AddItem(item), HttpStatus.OK);
    }

    @GetMapping(value = "/getOne/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ItemRespose> getOnePost(@PathVariable(value = "id") int id) {
        ItemRespose item = itemService.getItemById(id);
        if (item == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<ItemRespose>> getAllItems() {
        List<ItemRespose> items = itemService.getAllItems();
        if (items != null) {
            return new ResponseEntity<>(items, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Item> updateitem(@PathVariable(value = "id") int id,
                                           @RequestBody Item item) {
        return new ResponseEntity<>(itemService.updateItem(id, item),
                HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Item>> deleteitem(@PathVariable(value = "id") int id) {
        List<Item> item = itemService.getAllItem();
        if ( itemService.deleteItem(id) ) {
            return new ResponseEntity<>(item, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



//    @GetMapping("/items/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    private ResponseEntity<Item> getItem(@PathVariable("id") int id) {
//        Item item = itemService.getItemById(id);
//        return ResponseEntity.status(HttpStatus.OK).body(item);
//    }
}
