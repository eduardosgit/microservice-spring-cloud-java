package br.com.estudo.springservice.integration;

import br.com.estudo.springservice.services.PersonService;
import br.com.estudo.springservice.testsupport.BaseIntegrationTest;
import br.com.estudo.springservice.domain.Person;
import br.com.estudo.springservice.repositories.PersonRepository;
import br.com.estudo.springservice.resources.request.PersonRequest;
import br.com.estudo.springservice.resources.response.PersonResponse;
import jakarta.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
class PersonServiceIT extends BaseIntegrationTest {

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonRepository personRepository;

    @Test
    void shouldCreatePersonSuccessfully() {
        PersonRequest request = new PersonRequest("Eduardo", "edu@test.com");

        PersonResponse response = personService.createPerson(request);

        assertNotNull(response);
        assertEquals("Eduardo", response.name());
        assertEquals(1, personRepository.count());
    }

    @Test
    void shouldFindPersonByIdSuccessfully() {
        Person saved = personRepository.save(new Person(null, "Eduardo", "edu@test.com"));

        PersonResponse response = personService.findPersonById(saved.getId());

        assertEquals("Eduardo", response.name());
    }

    @Test
    void shouldReturnAllPersons() {
        personRepository.save(new Person(null, "Eduardo", "edu@test.com"));
        personRepository.save(new Person(null, "Maria", "maria@test.com"));

        List<PersonResponse> list = personService.findAllPersons();

        assertEquals(2, list.size());
    }

    @Test
    void shouldUpdatePersonSuccessfully() {
        Person saved = personRepository.save(new Person(null, "Old", "old@test.com"));

        PersonRequest request = new PersonRequest("New", "new@test.com");

        PersonResponse response = personService.updatePerson(saved.getId(), request);

        assertEquals("New", response.name());
        assertEquals("new@test.com", response.email());
    }

    @Test
    void shouldRemovePersonSuccessfully() {
        Person saved = personRepository.save(new Person(null, "Eduardo", "edu@test.com"));

        personService.removePerson(saved.getId());

        assertEquals(0, personRepository.count());
    }
}