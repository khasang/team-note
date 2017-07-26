package io.khasang.teamnote.controller;

import io.khasang.teamnote.model.Message;
import io.khasang.teamnote.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
    @Value("Jack")
    @Autowired
    private Message message;

    @Autowired
    CatService catService;


    // http://localhost:8080/
    @RequestMapping("/")
    public String helloPage(Model model){
        model.addAttribute("name", message.getName());
        return "hello";
    }

    @RequestMapping("/create")
    public String statusCatTableCreation(Model model){
        model.addAttribute("create", catService.createCatTableStatus());
        return "create";
    }

    @RequestMapping("/admin")
    public String getAdminPage(Model model){
        model.addAttribute("admin", "Very Secure Page for admins!");
        return "admin";
    }

    @RequestMapping("/superadmin")
    public String getSuperAdminPage(Model model){
        model.addAttribute("superadmin", "Very Secure Page for super admins!");
        return "superadmin";
    }
}
