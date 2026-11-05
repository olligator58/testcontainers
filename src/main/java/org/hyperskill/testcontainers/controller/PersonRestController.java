package org.hyperskill.testcontainers.controller;

import org.hyperskill.testcontainers.persistence.PersonRepository;
import org.hyperskill.testcontainers.service.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonRestController {
    private final PersonRepository repository;

    @Autowired
    PersonRestController(PersonRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/persons/{name}")
    public ResponseEntity<Person> getPerson(@PathVariable String name) {
        return ResponseEntity.of(repository.findByName(name));
    }
}
