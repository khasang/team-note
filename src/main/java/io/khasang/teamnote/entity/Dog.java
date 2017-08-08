package io.khasang.teamnote.entity;

import javax.persistence.*;

@Entity
@Table(name = "dogs")
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //id генерируется автоматически. нам не надо его вставлять
    @Column(name = "dog_id")
    private long id;

    @Column(name = "dog_name")
    private String name;

    @Transient // поле игнорируется бд
    private String desciption;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }
}
