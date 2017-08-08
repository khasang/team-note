package io.khasang.teamnote.model;

import org.springframework.stereotype.Component;

@Component
public class CatHw {
    private int id;
    private String name;

    public CatHw(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public CatHw() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
