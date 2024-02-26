package com.pablovallejos.mapper;

import com.pablovallejos.domain.Person;
import com.pablovallejos.domain.dto.PersonDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-23T21:27:19-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class PersonMapperImpl implements PersonMapper {

    @Override
    public Person toEntity(PersonDto personDto) {
        if ( personDto == null ) {
            return null;
        }

        Person.PersonBuilder person = Person.builder();

        person.name( personDto.getName() );
        person.lastName( personDto.getLastName() );
        person.birthdate( personDto.getBirthdate() );
        person.documentNumber( personDto.getDocumentNumber() );
        person.email( personDto.getEmail() );
        person.phone( personDto.getPhone() );
        person.status( personDto.getStatus() );

        return person.build();
    }

    @Override
    public PersonDto toDto(Person person) {
        if ( person == null ) {
            return null;
        }

        PersonDto personDto = new PersonDto();

        personDto.setId( person.getId() );
        personDto.setName( person.getName() );
        personDto.setLastName( person.getLastName() );
        personDto.setBirthdate( person.getBirthdate() );
        personDto.setDocumentNumber( person.getDocumentNumber() );
        personDto.setEmail( person.getEmail() );
        personDto.setPhone( person.getPhone() );
        personDto.setStatus( person.getStatus() );

        return personDto;
    }

    @Override
    public void updateFromDto(PersonDto personDto, Person person) {
        if ( personDto == null ) {
            return;
        }

        person.setName( personDto.getName() );
        person.setLastName( personDto.getLastName() );
        person.setBirthdate( personDto.getBirthdate() );
        person.setDocumentNumber( personDto.getDocumentNumber() );
        person.setEmail( personDto.getEmail() );
        person.setPhone( personDto.getPhone() );
        person.setStatus( personDto.getStatus() );
    }
}
