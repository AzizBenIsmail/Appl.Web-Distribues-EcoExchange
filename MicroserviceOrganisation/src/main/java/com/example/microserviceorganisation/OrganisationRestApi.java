package com.example.microserviceorganisation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrganisationRestApi {

    private String hello = "Hello I'm An Organisation";

    @RequestMapping("/hello")
    public String sayHello() {
        return hello;
    }

    @Autowired
    private OrganisationService organisationService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Organisation> createorganisation(@RequestBody Organisation organisation) {
        return new ResponseEntity<>(organisationService.AddOrganisation(organisation), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Organisation> updateorganisation(@PathVariable(value = "id") int id,
                                           @RequestBody Organisation organisation) {
        return new ResponseEntity<>(organisationService.updateOrganisation(id, organisation),
                HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteorganisation(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(organisationService.deleteOrganisation(id), HttpStatus.OK);
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Organisation>> getorganisation() {
        List<Organisation> organisation = organisationService.getAllOrganisation();
        if (organisation != null) {
            return new ResponseEntity<>(organisation, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/organisations/{id}")
    @ResponseStatus(HttpStatus.OK)
    private ResponseEntity<Organisation> getOrganisation(@PathVariable("id") int id) {
        Organisation organisation = organisationService.getOrganisationById(id);
        return ResponseEntity.status(HttpStatus.OK).body(organisation);
    }
}
