package com.barclays.util;

import com.barclays.model.Address;
import com.barclays.model.Message;
import com.barclays.model.Person;
import com.barclays.repository.MessageRepository;
import com.barclays.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Populator {

    private MessageRepository messageRepository;
    private PersonRepository personRepository;

    @EventListener(ContextRefreshedEvent.class)
    public void populate(){
        Message m1 = new Message();
        m1.setContent("Bryan is Best");
        messageRepository.save(m1);

        Message m2 = new Message("May the Force be with you");
        messageRepository.save(m2);

        Message m3 = new Message("Rubber Baby Buggy Bumpers");
        messageRepository.save(m3);

        Message m4 = new Message("Unique New York");
        messageRepository.save(m4);
    }

    //@EventListener(ContextRefreshedEvent.class)
    public void populatePeeps(){
        Person person = new Person();
        person.setName("Bryan");
        person.setEmailAddress("who@cares.com");

        Address address = new Address();
        address.setLineOne("123 Tom St");
        address.setLineTwo("Unit G");
        address.setState("Utah");
        address.setPostalCode("84065");
        address.setCountry("USA");

        person.setAddress(address);

        personRepository.save(person);

        Person person2 = new Person();
        person.setName("Steve");
        person.setEmailAddress("steve@abc.com");

        personRepository.save(person);
    }
}
