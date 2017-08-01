package io.khasang.teamnote.entity;

import javax.persistence.*;

@Entity
@Table(name ="cats")
public class Cat {

    public Cat() {
    }

    @Id
    @Column(name="cat_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @OneToOne
    @JoinColumn(name = "cat_name")
    private Home home;

    @Transient
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }
}
