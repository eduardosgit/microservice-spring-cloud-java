package br.com.estudo.springservice.services;

import br.com.estudo.springservice.model.Person;
import br.com.estudo.springservice.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public Person findById(String id) {
        log.info("M=findById");

        return Person.builder()
                .id(counter.incrementAndGet())
                .name("Eduardo")
                .email("email@gmail.com")
                .build();
    }

    public List<Person> findAll() {
        log.info("M=findAll");
        List<Person> persons = new ArrayList<>();
        return persons;
    }

    public Person createPerson(Person person) {
        log.info("M=save");
        return person;
    }

    public void removePerson(Person person) {
        log.info("M=remove");

    }

    public Person updatePerson(Person person) {
        log.info("M=update");
        return person;
    }

}
