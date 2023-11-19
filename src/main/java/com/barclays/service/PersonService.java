package com.barclays.service;

import com.barclays.model.Person;

import java.util.List;

public interface PersonService {
    List<Person> findByName(String name);

    List<Person> findAll();

    List<Person> searchByName(String name);

    Person save(Person person);
}
