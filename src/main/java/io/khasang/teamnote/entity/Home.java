package io.khasang.teamnote.entity;

import javax.persistence.*;

@Entity
@Table(name = "cat_home_number")
public class Home {

    @Id
    @Column(name = "home_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "number")
    private String number;

    @Column(name="cat_name")
    private String catName;


    public Home() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }



    @Override
    public String toString() {
        return "Home{" +
                "id=" + id +
                ", number='" + number + '\'' +
                '}';
    }
}
