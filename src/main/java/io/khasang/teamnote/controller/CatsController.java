package io.khasang.teamnote.controller;

import io.khasang.teamnote.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author gothmog on 27.07.2017.
 */
@Controller
public class CatsController {
    @Autowired
    CatService catService;

    @RequestMapping("/create")
    public String statusCatTableCreation(Model model) {
        model.addAttribute("create", catService.createCatTableStatus());
        return "cats/create";
    }

    @RequestMapping("/insert")
    public String statusCatTableInsert(Model model) {
        model.addAttribute("insert", catService.insertCatTableStatus());
        return "cats/insert";
    }

    @RequestMapping("/update")
    public String statusCatTableUpdate(Model model) {
        model.addAttribute("update", catService.updateCatTableStatus());
        return "cats/update";
    }

    @RequestMapping("/delete")
    public String statusCatTableDelete(Model model) {
        model.addAttribute("delete", catService.deleteCatTableStatus());
        return "cats/delete";
    }

    @RequestMapping("/deleteCat")
    public String statusCatNameDelete(Model model) {
        model.addAttribute("deleteCat", catService.deleteCatsName());
        return "cats/deleteCat";
    }
}
