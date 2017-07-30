package io.khasang.teamnote.controller;

import io.khasang.teamnote.models.SomeModel;
import io.khasang.teamnote.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

    private final SomeModel someModel;
    @Autowired
    CatService catService;

    @Autowired
    public AppController(SomeModel someModel) {
        someModel.setFirstName("Spring");
        someModel.setLastName("WORLD");
        this.someModel = someModel;
    }


    @RequestMapping("/")
    public String startPage(Model model){
        model.addAttribute("firstName",someModel.getFirstName());
        model.addAttribute("lastName",someModel.getLastName());
        return "index";
    }

    @RequestMapping("/cats")
    public String createCatTable(Model model){
        model.addAttribute("catTableStatus",catService.createTable());
        return "catTableStatus";
    }

    @RequestMapping("/insert")
    public String insertNewCat(Model model){
        model.addAttribute("catTableStatus", catService.insertValue());
        return "catTableStatus";
    }

    @RequestMapping("/update")
    public String changeCatName(Model model){
        model.addAttribute("catTableStatus",catService.updateValue());
        return "catTableStatus";
    }

    @RequestMapping("/delete")
    public String deleteCate(Model model){
        model.addAttribute("catTableStatus",catService.deleteValue());
        return "catTableStatus";
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


}
