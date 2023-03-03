package com.wicinski.clothingstore;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonController {

    // standard constructors

    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/persons")
    public List<Person> getPersons() {
        return (List<Person>) personRepository.findAll();
    }

    @PostMapping("/persons")
    void addPerson(@RequestBody Person person) {
        personRepository.save(person);
    }

    @DeleteMapping("/persons/{id}")
    void deletePerson(@RequestBody Person person) {
        personRepository.delete(person);
    }
}

