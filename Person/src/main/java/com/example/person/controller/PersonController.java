package com.example.person.controller;

import com.example.person.model.Person;
import com.example.person.services.PersonService;
import com.example.person.services.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/api")
public class PersonController {

    private final PersonService personService;
    private final PersonServiceImpl personServiceImpl;

    @Autowired
    public PersonController(PersonService personService, PersonServiceImpl personServiceImpl) {
        this.personService = personService;
        this.personServiceImpl = personServiceImpl;
    }

    @PostMapping("/persons")
    public Person createPerson(@RequestBody Person person){
        return personService.createPerson(person);
    }

//    @GetMapping("/persons")
//    public List<Person> getPersons(){
//        return personService.getPersons();
//    }

    @GetMapping("/persons")
    public String viewHomePage(Model model){
        model.addAttribute("alluserlist", personServiceImpl.getPersons());
    return "index";
    }

    @PutMapping("/persons/{id}")
    public Person updatePerson(@RequestBody Person person, @PathVariable UUID id){
        return personService.updatePerson(person, id);
    }

    @DeleteMapping("/persons/{id}")
    public Person deletePerson(@PathVariable UUID id){
        return personService.deletePerson(id);
    }
}
