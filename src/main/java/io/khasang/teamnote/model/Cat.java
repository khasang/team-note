package io.khasang.teamnote.model;

/**
 * @author gothmog on 28.07.2017.
 */
public class Cat {
    private int id;
    private String name;

    public Cat() {
    }

    public Cat(String name) {
        this.name = name;
    }

    public Cat(int id, String name) {
        this.id = id;
        this.name = name;
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
