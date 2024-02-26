package com.pablovallejos.validation;

import com.pablovallejos.domain.dto.PersonDto;
import com.pablovallejos.repository.PersonRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class PersonValidator {
    private PersonRepository personRepository;


    public PersonValidator(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public PersonValidator() {

    }

    public boolean isValidEmail(String email) {
        // Valida el formato del correo electrónico utilizando la anotación @Email
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<PersonDto>> violations = validator.validateValue(PersonDto.class, "email", email);
        return violations.isEmpty();
    }


    public boolean existsByEmail(String email) {
        return personRepository.findByEmail(email) != null;
    }

}
