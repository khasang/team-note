package io.khasang.teamnote.controller;

import io.khasang.teamnote.model.Message;
import net.yandex.speller.services.spellservice.CheckTextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.MalformedURLException;

@Controller
public class AppController {
    @Value("Jack Jack Jack")
    private final Message message;

    @Autowired
    public AppController(Message message) {
        this.message = message;
    }

    // http://localhost:8080/
    @RequestMapping("/")
    public String helloPage() {
        return "order";
    }

    @RequestMapping("/admin")
    public String getAdminPage(Model model) {
        model.addAttribute("admin", "Very Secure Page for admins!!!");
        return "admin";
    }

    @RequestMapping("/superadmin")
    public String getSuperAdminPage(Model model) {
        model.addAttribute("superadmin", "Very Secure Page for superadmins!!!");
        return "superadmin";
    }

    @RequestMapping("/user")
    public String getUserPage(Model model) {
        model.addAttribute("user", "Very Secure Page for user!!!");
        return "user";
    }

    @RequestMapping(value = {"/check/{text}"}, method = RequestMethod.GET)
    public ModelAndView checkWordSpelling(@PathVariable("text") String text) throws MalformedURLException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("checkSpell");
        modelAndView.addObject("check", CheckTextUtil.response(text));
        return modelAndView;
    }
}
