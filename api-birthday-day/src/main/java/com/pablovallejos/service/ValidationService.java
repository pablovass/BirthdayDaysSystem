package com.pablovallejos.service;
import com.pablovallejos.domain.dto.PersonDto;
import com.pablovallejos.exception.ValidationExceptionMessage;
import com.pablovallejos.validation.PersonValidator;
import jakarta.validation.ValidationException;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {

    private PersonValidator personValidator;


    public ValidationService(PersonValidator personValidator) {
        this.personValidator = personValidator;
    }


    public ValidationException validatePerson(PersonDto person) throws ValidationException {
        if (!personValidator.isValidEmail(person.getEmail())) {
            throw new ValidationException(String.valueOf(ValidationExceptionMessage.EMAIL_INVALID));
        }

        if (personValidator.existsByEmail(person.getEmail())) {
            throw new ValidationException(String.valueOf(ValidationExceptionMessage.EMAIL_ALREADY_EXISTS));
        }
        return null;
    }
}