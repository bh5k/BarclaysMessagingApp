package com.barclays.service;

import com.barclays.model.Person;
import com.barclays.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;

    @Override
    public List<Person> findByName(String name) {
        return personRepository.findByName(name);
    }

    @Override
    public List<Person> findAll() {
        List<Person> peeps = new ArrayList<>();
        personRepository.findAll().forEach(peeps::add);
        return peeps;
    }

    public List<Person> searchByName(String name) {
        return personRepository.searchByName(name);
    }
}
