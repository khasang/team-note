package io.khasang.teamnote.model;

import org.springframework.stereotype.Component;

@Component
public class Message {
    private String Name;

    public Message() {
    }

    public Message(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
