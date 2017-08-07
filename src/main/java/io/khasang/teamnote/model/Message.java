package io.khasang.teamnote.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class Message {
    //Все бины имеют scope singleton не является потоко безопасным
    // scope prototype Возвращает каждый раз новый экземпляр бина. является потоко безопасным
    // scope request   Возвращает новый экземпляр бина на HTTP запрос.
    // scope session   Возвращает новый экземпляр бина для каждой HTTP сесии.
    // scope global-session   Возвращает новый экземпляр бина для глобальной HTTP сесии.
    private String name;

    public Message() {
    }

    public Message(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




}
