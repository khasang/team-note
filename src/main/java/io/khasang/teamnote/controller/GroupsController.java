package io.khasang.teamnote.controller;

import io.khasang.teamnote.entity.Groups;
import io.khasang.teamnote.service.GroupsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/groups")
public class GroupsController {
    private final GroupsService groupsService;

    @Autowired
    public GroupsController(GroupsService groupsService) {
        this.groupsService = groupsService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Groups addGroups(@RequestBody Groups groups) {
        return groupsService.addGroups(groups);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Groups> getGroupss(){
        return groupsService.getList();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Groups getById(@PathVariable(value = "id") String inputId){
        return groupsService.getById(Long.parseLong(inputId));
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Groups update(@RequestBody Groups groups){
        return groupsService.update(groups);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Groups delete(@PathVariable(value = "id") String inputId){
        return groupsService.delete(Long.parseLong(inputId));
    }
}
