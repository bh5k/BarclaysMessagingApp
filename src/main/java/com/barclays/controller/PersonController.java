package com.barclays.controller;

import com.barclays.model.Person;
import com.barclays.service.PersonService;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@AllArgsConstructor
public class PersonController {

    private PersonService personService;

    @PostMapping("/person")
    public Person createPerson (@RequestBody Person person) {
        return personService.save(person);
    }

    @PutMapping("/person")
    public Person updatePerson(@RequestBody Person person) {
        return personService.save(person);
    }

    //http://localhost:8080/person?filter=Bryan
    @GetMapping(value = "/person")
    public List<Person> getPeople(@PathParam("name") String name) {
        List<Person> peeps = Collections.emptyList();
        if(StringUtils.isNotBlank(name)) {
            peeps = personService.findByName(name);
        }
        else {
            peeps = personService.findAll();
        }

        return peeps;
    }

    @GetMapping(value = "/person/{id}")
    public Person getPerson(@PathVariable int id) {
        return personService.findById(id);
    }

    @GetMapping("/person/search")
    public List<Person>searchByName(@PathParam("name") String name) {
        return personService.searchByName(name);
    }
}
