package io.khasang.teamnote.controller;

import io.khasang.teamnote.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
    @Value("Name of the Wind.")
    private final Message message;

    @Autowired
    private AppController(Message message) {
        this.message = message;
    }

    @RequestMapping("/")
    public String helloPage(Model model) {
        model.addAttribute("name", message.getMessage());
        return "hello";
    }
}
