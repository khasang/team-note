package io.khasang.teamnote.entity;

import javax.persistence.*;

@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "user")
    private String user;

    @Column(name = "item")
    private byte[] item;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public byte[] getItem() {
        return item;
    }

    public void setItem(byte[] item) {
        this.item = item;
    }
}
