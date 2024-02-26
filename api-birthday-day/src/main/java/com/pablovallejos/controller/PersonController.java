package com.pablovallejos.controller;
import com.pablovallejos.domain.dto.PersonDto;
import com.pablovallejos.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/api/persons")
@CrossOrigin
public class PersonController {
    private PersonService personService;
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public  ResponseEntity<List<PersonDto>> getAllPerson() {
        List<PersonDto> persons=personService.listAllPerson();
        return ResponseEntity.ok(persons);
    }
    @GetMapping("/{id}")
    public  ResponseEntity<PersonDto> getPerson(@PathVariable("id")UUID id) {
         PersonDto personDto =personService.getPerson(id);
        return ResponseEntity.ok(personDto);
    }
    @PostMapping("/")
    public  ResponseEntity<PersonDto>createPerson(@RequestBody PersonDto personDto){
        PersonDto personDtoCreate =personService.createPerson(personDto);
        return  ResponseEntity.status(HttpStatus.CREATED).body(personDtoCreate);
    }
    @PatchMapping("/update")
    public ResponseEntity<PersonDto> updatePerson( @RequestBody PersonDto personDto) {
        PersonDto updatedPersonDto = personService.updatePerson(personDto);
            return ResponseEntity.ok(updatedPersonDto);
    }
    @DeleteMapping("/{id}/disable")
    public ResponseEntity<PersonDto> disablePerson(@PathVariable("id")UUID id){
        PersonDto personDtoa=personService.disablePersonByDocumentNumber(id);
        return ResponseEntity.ok(personDtoa);
    }
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<PersonDto> deletePerson(@PathVariable("id") UUID id){
        return personService.deletePerson(id);
    }

}


