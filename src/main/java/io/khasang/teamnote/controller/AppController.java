package io.khasang.teamnote.controller;

import io.khasang.teamnote.models.SomeModel;
import io.khasang.teamnote.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
