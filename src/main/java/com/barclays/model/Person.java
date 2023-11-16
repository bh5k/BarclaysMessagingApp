package com.barclays.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Person {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String emailAddress;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Address address;

    public Person(String name, String emailAddress) {
        this.name = name;
        this.emailAddress = emailAddress;
    }

    public Person (String name) {
        this.name = name;
    }

}
