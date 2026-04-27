package br.com.estudo.springservice.services;

import br.com.estudo.springservice.domain.Person;
import br.com.estudo.springservice.repositories.PersonRepository;
import br.com.estudo.springservice.resources.request.PersonRequest;
import br.com.estudo.springservice.resources.response.PersonResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    @Test
    void shouldReturnPersonResponse_WhenPersonExists() {
        Person person = new Person(1L, "Eduardo", "edu@test.com");
        when(personRepository.findById(1L)).thenReturn(Optional.of(person));

        PersonResponse response = personService.findPersonById(1L);

        assertNotNull(response);
        assertEquals("Eduardo", response.name());
        verify(personRepository).findById(1L);
    }

    @Test
    void shouldThrowException_WhenPersonNotFound() {
        when(personRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> personService.findPersonById(1L));
    }

    @Test
    void shouldReturnListOfPersons() {
        List<Person> persons = List.of(
                new Person(1L, "Eduardo", "edu@test.com"),
                new Person(2L, "Maria", "maria@test.com")
        );
        when(personRepository.findAll()).thenReturn(persons);

        List<PersonResponse> response = personService.findAllPersons();

        assertEquals(2, response.size());
        verify(personRepository).findAll();
    }

    @Test
    void shouldCreatePersonSuccessfully() {
        PersonRequest request = new PersonRequest("Eduardo", "edu@test.com");
        Person saved = new Person(1L, "Eduardo", "edu@test.com");
        when(personRepository.save(any(Person.class))).thenReturn(saved);

        PersonResponse response = personService.createPerson(request);

        assertNotNull(response);
        assertEquals("Eduardo", response.name());
        verify(personRepository).save(any(Person.class));
    }

    @Test
    void shouldRemovePersonSuccessfully() {
        Person person = new Person(1L, "Eduardo", "edu@test.com");
        when(personRepository.findById(1L)).thenReturn(Optional.of(person));

        personService.removePerson(1L);

        verify(personRepository).delete(person);
    }

    @Test
    void shouldThrowException_WhenRemovingNonExistingPerson() {
        when(personRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> personService.removePerson(1L));
    }

    @Test
    void shouldUpdatePersonSuccessfully() {
        Person existing = new Person(1L, "Old Name", "old@test.com");
        PersonRequest request = new PersonRequest("New Name", "new@test.com");

        when(personRepository.findById(1L)).thenReturn(Optional.of(existing));
        when(personRepository.save(any(Person.class))).thenReturn(existing);

        PersonResponse response = personService.updatePerson(1L, request);

        assertEquals("New Name", response.name());
        assertEquals("new@test.com", response.email());
        verify(personRepository).save(any(Person.class));
    }

    @Test
    void shouldThrowException_WhenUpdatingNonExistingPerson() {
        when(personRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> personService.updatePerson(1L, new PersonRequest("A", "b@test.com")));
    }
}

