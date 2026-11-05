package org.hyperskill.testcontainers.persistence;


import org.hyperskill.testcontainers.service.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PersonRepository extends CrudRepository<Person, Long> {
    Optional<Person> findByName(String name);
}
