package io.khasang.teamnote.controller;

import io.khasang.teamnote.model.Message;
import io.khasang.teamnote.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppController {
    @Value("Name of the Wind.")
    private final Message message;

    @Autowired
    private AppController(Message message) {
        this.message = message;
    }

    @Autowired
    private BookService bookService;

    @RequestMapping("/")
    public String helloPage(Model model) {
        model.addAttribute("name", message.getMessage());
        return "hello";
    }

    @RequestMapping("/addchar")
    public String statusAddCharacter(Model model,
                                     @RequestParam(value = "name") String name,
                                     @RequestParam(value = "order") String order) {
        model.addAttribute("add", bookService.createNewBookCharacter(name, order));
        return "addCharacter";
    }

    @RequestMapping("/updatechar")
    public String statusUpdateCharacter(Model model,
                                        @RequestParam(value = "id") int id,
                                        @RequestParam(value = "name") String name,
                                        @RequestParam(value = "order") String order) {
        model.addAttribute("update", bookService.updateBookCharacter(id, name, order));
        return "updateCharacter";
    }

    @RequestMapping("/deletechar")
    public String statusDeleteCharacter(Model model,
                                        @RequestParam(value = "id") int id) {
        model.addAttribute("delete", bookService.deleteBookCharacter(id));
        return "deleteCharacter";
    }
}
