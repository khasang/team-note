package io.khasang.teamnote.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "Person")
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    public Person() {
    }
}
