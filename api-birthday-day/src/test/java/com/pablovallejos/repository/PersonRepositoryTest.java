package com.pablovallejos.repository;

import com.pablovallejos.domain.Person;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.List;


@DataJpaTest
class PersonRepositoryTest {
    @Autowired // se inyecta PersonRepository No funciona con @Mock
    private PersonRepository personRepository;

    @Test
    public void whenCreatePersonById_thenRetunPerson() {
        Person person = Person.builder()
                .name("jamas")
                .lastName("laber")
                .birthdate(LocalDateTime.parse("32-19-1986"))
                .documentNumber("3223")
                .email("pablo@gmail.com")
                .phone("3232")
                .build();
        personRepository.save(person);
//List<Person>people=personRepository.findByDocumentNumber("3223");
  //      assertEquals("3223", people.get(0).getDocumentNumber());
     //  assertEquals("jama", person.getName());
     //  assertEquals("laber", person.getLastName());
     //  assertEquals("32-19-1986", person.getBirthdate());
     //  assertEquals("3223", person.getDocumentNumber());
     //  assertEquals("pablo@gmail.com", person.getEmail());
     //  assertEquals("3232", person.getPhone());
    }
}