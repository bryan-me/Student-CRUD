package com.example.person.services;

import com.example.person.model.Person;

import java.util.List;
import java.util.UUID;

public interface PersonService {

    Person createPerson(Person person);

    List<Person> getPersons();

    Person getPerson(UUID id);

    Person updatePerson(Person person, UUID id);

    Person deletePerson(UUID id);
}
