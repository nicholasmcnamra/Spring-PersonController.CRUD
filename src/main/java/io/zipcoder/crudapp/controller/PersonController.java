package io.zipcoder.crudapp.controller;

import io.zipcoder.crudapp.models.Person;
import io.zipcoder.crudapp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/people")
public class PersonController {

@Autowired
private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        return new ResponseEntity<>(personService.create(person), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable long id) { //PathVariable tells Spring where to go
        return new ResponseEntity<>(personService.find(id), HttpStatus.OK);
    }

    @GetMapping
    public List<Person> getPersonList() {
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@RequestBody Person person, @PathVariable long id) {
        return new ResponseEntity<>(personService.update(id, person), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deletePerson(@PathVariable long id) {
        return new ResponseEntity<>(personService.delete(id), HttpStatus.OK);
    }
}
