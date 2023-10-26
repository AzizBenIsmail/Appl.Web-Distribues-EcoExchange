package com.example.microserviceorganisation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = " *")
@RestController
public class OrganisationRestApi {

    private String hello = "Hello I'm An Organisation";

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/hello")
    public String sayHello() {
        return hello;
    }

    @Autowired
    private OrganisationService organisationService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Organisation> createorganisation(@RequestBody Organisation organisation) {
        return new ResponseEntity<>(organisationService.AddOrganisation(organisation), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Organisation> updateorganisation(@PathVariable(value = "id") int id,
                                           @RequestBody Organisation organisation) {
        return new ResponseEntity<>(organisationService.updateOrganisation(id, organisation),
                HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteorganisation(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(organisationService.deleteOrganisation(id), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
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

    //@CrossOrigin(origins = "http://localhost:4200/organisations/{id}")
    @GetMapping("/organisations/{id}")
    @ResponseStatus(HttpStatus.OK)
    private ResponseEntity<Organisation> getOrganisation(@PathVariable("id") int id) {
        Organisation organisation = organisationService.getOrganisationById(id);
        return ResponseEntity.status(HttpStatus.OK).body(organisation);
    }
}
