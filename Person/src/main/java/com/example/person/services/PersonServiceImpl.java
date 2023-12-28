package com.example.person.services;

import com.example.person.model.Person;
import com.example.person.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService{
    @Autowired private PersonRepository personRepository;
    @Override
    public Person createPerson(Person person) {
        if(person.getFirstName() == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        return personRepository.save(person);
    }

    @Override
    public List<Person> getPersons() {
        return personRepository.findAll();
    }

    @Override
    public Person getPerson(UUID id) {
//        Optional<Person> optional =
//
        return null;
    }

    @Override
    public Person updatePerson(Person updatedPerson, UUID id) {
        Optional<Person> optional = personRepository.findById(id);

        if(optional.isPresent()){
            Person existingPerson = optional.get();

            if(updatedPerson.getFirstName() != null){
                existingPerson.setFirstName(updatedPerson.getFirstName());
            }

            if(updatedPerson.getLastName() != null){
                existingPerson.setLastName(updatedPerson.getLastName());
            }

            if(updatedPerson.getGender() != null){
                existingPerson.setGender(updatedPerson.getGender());
            }

            if(updatedPerson.getDateOfBirth() != null){
                existingPerson.setDateOfBirth(updatedPerson.getDateOfBirth());
            }

            if(updatedPerson.getEmail() != null){
                existingPerson.setEmail(updatedPerson.getEmail());
            }
            if(updatedPerson.getAddress() != null){
                existingPerson.setAddress(updatedPerson.getAddress());
            }
            return null;
        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public Person deletePerson(UUID id) {
        Optional<Person> optional = personRepository.findById(id);
        if(optional.isPresent()){
            personRepository.deleteById(id);
        }
        return null;
    }
}
