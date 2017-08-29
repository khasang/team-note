package io.khasang.teamnote.controller;

import io.khasang.teamnote.entity.Item;
import io.khasang.teamnote.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/item")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Item addItem(@RequestBody Item item) {
        return itemService.addItem(item);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Item> getItems() {
        return itemService.getList();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Item getById(@PathVariable(value = "id") String inputId) {
        return itemService.getById(Long.parseLong(inputId));
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Item update(@RequestBody Item item) {
        return itemService.update(item);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Item delete(@PathVariable(value = "id") String inputId) {
        return itemService.delete(Long.parseLong(inputId));
    }
}
