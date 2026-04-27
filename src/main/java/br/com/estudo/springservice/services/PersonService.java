package br.com.estudo.springservice.services;

import br.com.estudo.springservice.domain.Person;
import br.com.estudo.springservice.repositories.PersonRepository;
import br.com.estudo.springservice.resources.request.PersonRequest;
import br.com.estudo.springservice.resources.response.PersonResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public PersonResponse findPersonById(Long id) {
        log.info("M=findById");

        return new PersonResponse(findOrThrow(id));
    }

    public List<PersonResponse> findAllPersons() {
        log.info("M=findAllPersons");

        return personRepository.findAll()
                .stream()
                .map(PersonResponse::new)
                .toList();
    }

    public PersonResponse createPerson(PersonRequest personRequest) {
        log.info("M=createPerson");

        Person person = Person.builder()
                .name(personRequest.name())
                .email(personRequest.email())
                .build();

        return new PersonResponse(personRepository.save(person));
    }

    public void removePerson(Long id) {
        log.info("M=removePerson");

        personRepository.delete(findOrThrow(id));
    }

    public PersonResponse updatePerson(Long id, PersonRequest personRequest) {
        log.info("M=updatePerson");

        Person personEntity = findOrThrow(id);

        personEntity.setName(personRequest.name());
        personEntity.setEmail(personRequest.email());

        return new PersonResponse(personRepository.save(personEntity));
    }

    private Person findOrThrow(Long id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Person not found"));
    }

}
