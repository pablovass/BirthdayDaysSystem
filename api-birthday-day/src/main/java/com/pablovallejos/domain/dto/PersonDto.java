package com.pablovallejos.domain.dto;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {
    private UUID id;
    private String name;
    private String lastName;
    private String birthdate;
    private String documentNumber;
    @Email(message = "El correo electrónico no es válido")
    private String email;
    private String phone;
    private String status;
}
