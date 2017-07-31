package io.khasang.teamnote.controller;

import io.khasang.teamnote.model.BackupTable;
import io.khasang.teamnote.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
    @Value("Кошкин дом")
    private final Message message;

    @Autowired
    BackupTable backupTable;

    @Autowired
    public AppController(Message message) {
        this.message = message;
    }

    // http://localhost:8080/
    @RequestMapping("/")
    public String helloPage(Model model) {
        model.addAttribute("name", message.getName());
        return "hello";
    }

    @RequestMapping("/backup")
    public String makeTablebackUp(Model model){
        model.addAttribute("backUpMessage", backupTable.runBackupTable());
        return "backUp";
    }

    @RequestMapping("/admin")
    public String getAdminPage(Model model){
        model.addAttribute("admin", "Very Secure Page for admins!!!");
        return "admin";
    }

    @RequestMapping("/superadmin")
    public String getSuperAdminPage(Model model){
        model.addAttribute("superadmin", "Very Secure Page for superadmins!!!");
        return "superadmin";
    }

    @RequestMapping("/user")
    public String getUserPage(Model model){
        model.addAttribute("user", "Very Secure Page for user!!!");
        return "user";
    }


}
