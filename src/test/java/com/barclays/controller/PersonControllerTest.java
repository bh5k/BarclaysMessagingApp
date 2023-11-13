package com.barclays.controller;

import com.barclays.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PersonControllerTest {

    @Test
    public void testGetAllPeople() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Person[]> response =
                restTemplate.getForEntity("http://localhost:8080/person", Person[].class);
        Person[] peeps = response.getBody();
        assertEquals(1, peeps.length);
    }

    @Test
    public void testGetPerson() {
        RestTemplate restTemplate = new RestTemplate();
        Person person =
                restTemplate.getForObject("http://localhost:8080/person/2", Person.class);

        assertEquals("Bryan", person.getName());
    }
    
}
