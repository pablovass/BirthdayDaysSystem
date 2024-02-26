package com.pablovallejos.repository;

import com.pablovallejos.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
    public interface PersonRepository extends JpaRepository<Person, UUID> {
    public Person findByDocumentNumber(String documentNumber);
    Person findByEmail(String email);

}
