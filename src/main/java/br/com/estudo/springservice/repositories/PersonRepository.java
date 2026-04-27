package br.com.estudo.springservice.repositories;

import br.com.estudo.springservice.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
