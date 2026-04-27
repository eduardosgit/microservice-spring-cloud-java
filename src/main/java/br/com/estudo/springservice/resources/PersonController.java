package br.com.estudo.springservice.resources;

import br.com.estudo.springservice.resources.request.PersonRequest;
import br.com.estudo.springservice.resources.response.PersonResponse;
import br.com.estudo.springservice.services.PersonService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping("/{id}")
    public ResponseEntity<PersonResponse> findPersonById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(personService.findPersonById(id));
    }

    @GetMapping
    public ResponseEntity<List<PersonResponse>> findAllPersons() {
        return ResponseEntity.ok(personService.findAllPersons());
    }

    @PostMapping
    public ResponseEntity<PersonResponse> createPerson(@RequestBody @Valid PersonRequest personRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(personService.createPerson(personRequest));
    }

    @DeleteMapping("/{id}")
    public void removePerson(@PathVariable Long id) {
        personService.removePerson(id);
    }

    @PutMapping
    public ResponseEntity<PersonResponse> updatePerson(@PathVariable Long id, @Valid @RequestBody PersonRequest personRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(personService.updatePerson(id, personRequest));
    }
}