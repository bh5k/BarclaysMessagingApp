package com.barclays.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Person {

    private int id;
    private String name;
    private String emailAddress;

    public Person (String name) {
        this.name = name;
    }

}
