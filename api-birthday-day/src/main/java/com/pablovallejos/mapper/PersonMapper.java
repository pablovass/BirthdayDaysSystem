package com.pablovallejos.mapper;

import com.pablovallejos.domain.Person;
import com.pablovallejos.domain.dto.PersonDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(target = "id", ignore = true)
    Person toEntity(PersonDto personDto);

    PersonDto toDto(Person person);
   @Mapping(target = "id", ignore = true)
    void updateFromDto(PersonDto personDto, @MappingTarget Person person);
    default List<PersonDto> toDtoList(List<Person> personList) {
        if (personList == null) {
            return new ArrayList<>();
        }
        return personList.stream().map(this::toDto).collect(Collectors.toList());
    }

}


