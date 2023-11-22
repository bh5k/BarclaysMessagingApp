package com.barclays.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Person {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String emailAddress;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Address address;

    @JsonManagedReference
    @OneToMany(mappedBy = "sender", fetch = FetchType.LAZY)
    private List<Message> sentMessages;


    public Person(String name, String emailAddress) {
        this.name = name;
        this.emailAddress = emailAddress;
    }

    public Person (String name) {
        this.name = name;
    }

}
