package com.barclays.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Message {

    @Id
    @GeneratedValue
    private Integer id;

    private String content;

    @JsonBackReference
    @ManyToOne
    private Person sender;

    public Message(String content) {
        this.content = content;
    }

}
