package br.com.estudo.springservice.controllers;

import br.com.estudo.springservice.model.Person;
import br.com.estudo.springservice.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping("/{id}")
    public Person findById(@PathVariable("id") String id) {
        return personService.findById(id);
    }

    @GetMapping
    public List<Person> findAll() {
        return personService.findAll();
    }

    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }

    @DeleteMapping
    public void removePerson(@RequestBody Person person) {
        personService.removePerson(person);
    }

    @PutMapping
    public Person updatePerson(@RequestBody Person person) {
        return personService.updatePerson(person);
    }
}