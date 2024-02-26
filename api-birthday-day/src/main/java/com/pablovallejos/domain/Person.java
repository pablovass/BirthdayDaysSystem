package com.pablovallejos.domain;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PERSON") // "user" es una palabra reservada de H2
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", length = 16)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birthdate")
    private String birthdate;

    @Column(name = "document_number")
    private String documentNumber;

    @Column(name = "email", nullable = true) // Email es opcional (puede ser nulo)
    private String email;

    @Column(name = "phone", nullable = true) // Phone es opcional (puede ser nulo)
    private String phone;

    @Column(name = "status")
    private String status;
}
