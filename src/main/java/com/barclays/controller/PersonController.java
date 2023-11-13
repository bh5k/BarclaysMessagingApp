package com.barclays.controller;

import com.barclays.model.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {

    @GetMapping(value = "/person")
    public List<Person> getPeople() {
        List<Person> peeps = new ArrayList<>();
        Person person = new Person();
        person.setName("Bryan");
        person.setEmailAddress("bryankhansen@gmail.com");
        peeps.add(person);
        return peeps;
    }

    @GetMapping(value = "/person/{id}")
    public Person getPerson(@PathVariable int id) {
        Person person = new Person();
        person.setName("Bryan");
        person.setEmailAddress("bryankhansen@gmail.com");
        return person;
    }

}
