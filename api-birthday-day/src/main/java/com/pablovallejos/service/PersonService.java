package com.pablovallejos.service;

import com.pablovallejos.domain.Person;
import com.pablovallejos.domain.dto.PersonDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface PersonService {
    public List<PersonDto> listAllPerson();
    public  PersonDto getPerson(UUID id);
    public  PersonDto createPerson(PersonDto person);
    public  PersonDto updatePerson(PersonDto person);
    ResponseEntity<PersonDto> deletePerson(UUID id);
    public PersonDto disablePersonByDocumentNumber(UUID id);
}
