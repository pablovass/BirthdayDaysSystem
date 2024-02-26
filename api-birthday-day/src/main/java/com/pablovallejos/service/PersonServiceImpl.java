package com.pablovallejos.service;

import com.pablovallejos.domain.Person;
import com.pablovallejos.domain.dto.PersonDto;
import com.pablovallejos.mapper.PersonMapper;
import com.pablovallejos.repository.PersonRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class PersonServiceImpl implements PersonService {
    private PersonRepository personRepository;
    private final PersonMapper personMapper;

    public PersonServiceImpl(PersonRepository personRepository, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;

    }

    @Override
    public List<PersonDto> listAllPerson() {
        return personMapper.toDtoList(personRepository.findAll());
    }

    @Override
    public PersonDto getPerson(UUID id) {
        Optional<Person> personOptional = personRepository.findById(id);
        Person personDb = personOptional.get();
        return personMapper.toDto(personDb);
    }

    @Override
    public PersonDto createPerson(PersonDto personDto) {
        Person personEntity = personMapper.toEntity(personDto);
        personEntity.setStatus("todo");
        Person savedPerson = personRepository.save(personEntity);
        return personMapper.toDto(savedPerson);
    }


    @Override
    public PersonDto updatePerson(PersonDto personDto) {
        Person existingPerson = personRepository.findByDocumentNumber(personDto.getDocumentNumber());

        if (existingPerson == null) {
            throw new EntityNotFoundException("Persona no encontrada con el número de documento: " + personDto.getDocumentNumber());
        }

        personMapper.updateFromDto(personDto, existingPerson);
        Person updatedPerson = personRepository.save(existingPerson);

        return personMapper.toDto(updatedPerson);
    }


    @Override
    public PersonDto disablePersonByDocumentNumber(UUID id) {
        Optional<Person> personOptional = personRepository.findById(id);
        if (personOptional.isPresent()) {
            Person personDb = personOptional.get();
            personDb.setStatus("DISABLED");
            personDb = personRepository.save(personDb);
            return personMapper.toDto(personDb);
        } else {
            return null;
        }
    }

    public ResponseEntity<PersonDto> deletePerson(UUID id) {
        Optional<Person> personOptional = personRepository.findById(id);
        if (personOptional.isPresent()) {
            Person personDb = personOptional.get();
            personRepository.delete(personDb);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }
}
