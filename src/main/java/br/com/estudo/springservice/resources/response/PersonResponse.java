package br.com.estudo.springservice.resources.response;

import br.com.estudo.springservice.domain.Person;

public record PersonResponse(
        Long id,
        String name,
        String email
) {
    public PersonResponse(Person person) {
        this(person.getId(),  person.getName(), person.getEmail());
    }
}
