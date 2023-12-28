package com.example.person.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "person")
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private UUID id;
    private String firstName;
    private String lastName;
    private String gender;
    private Date dateOfBirth;
    private String email;
    private String address;

    @CreationTimestamp
    private ZonedDateTime createdAt;
    private UUID createdBy;

    @CreationTimestamp
    private ZonedDateTime updatedAt;
    private UUID updatedBy;
}
