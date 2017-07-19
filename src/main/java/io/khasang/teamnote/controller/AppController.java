package io.khasang.teamnote.controller;

import io.khasang.teamnote.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
    @Value("Jack Vorobey")
    private final Message message;

    @Autowired
    public AppController(Message message) {
        this.message = message;
    }

    // http://localhost:8080/
    @RequestMapping("/")
    public String helloPage(Model model){
        model.addAttribute("name", message.getName());
        return "hello";
    }
}
