package io.khasang.teamnote.controller;

import io.khasang.teamnote.model.Message;
import net.yandex.speller.services.spellservice.CheckTextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.net.MalformedURLException;

@Controller
public class AppController {
    @Value("Jack")
    @Autowired
    private Message message;

    // http://localhost:8080/
    @RequestMapping("/")
    public String helloPage() {
        return "document";
    }

    @RequestMapping("/status")
    public String statusPage() {
        return "status";
    }

    @RequestMapping("/order")
    public String orderPage(){
        return "order";
    }

    @RequestMapping("/admin")
    public String getAdminPage(Model model) {
        model.addAttribute("admin", "Very Secure Page for admins!");
        return "admin";
    }

    @RequestMapping("/user")
    public String getUserPage(Model model) {
        model.addAttribute("user", "You are welcome!");
        return "user";
    }

    @RequestMapping("/superadmin")
    public String getSuperAdminPage(Model model) {
        model.addAttribute("superadmin", "Very Secure Page for super admins!");
        return "superadmin";
    }

    @RequestMapping(value = {"/password/{password}"}, method = RequestMethod.GET)
    public ModelAndView passwordEncode(@PathVariable("password") String password) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("password");
        modelAndView.addObject("crypt", new BCryptPasswordEncoder().encode(password));
        return modelAndView;
    }

    @RequestMapping(value = {"/check/{text}"}, method = RequestMethod.GET)
    public ModelAndView checkWordSpelling(@PathVariable("text") String text) throws MalformedURLException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("checkSpell");
        modelAndView.addObject("check", CheckTextUtil.response(text));
        return modelAndView;
    }

    @RequestMapping("/roles")
    public String RolePage(){
        return "role";
    }

    @RequestMapping("/users")
    public String getUsersPage(Model model) {
        return "users";
    }
}
