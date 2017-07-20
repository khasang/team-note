package io.khasang.teamnote.controller;

import io.khasang.teamnote.models.SomeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

    private final SomeModel someModel;

    @Autowired
    public AppController(SomeModel someModel) {
        someModel.setFirstName("Spring");
        someModel.setLastName("WORLD");
        this.someModel = someModel;
    }


    @RequestMapping("/")
    public String StartPage(Model model){
        model.addAttribute("firstName",someModel.getFirstName());
        model.addAttribute("lastName",someModel.getLastName());
        return "index";
    }

}
