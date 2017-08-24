package io.khasang.teamnote.controller;

import io.khasang.teamnote.entity.Role;
import io.khasang.teamnote.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/roles")
public class RoleController {
    final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Role addRole(@RequestBody Role role) {
        return roleService.addRole(role);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Role> getRoles() {
        return roleService.getList();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Role getById(@PathVariable(value = "id") String inputId) {
        return roleService.getById(Long.parseLong(inputId));
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Role update(@RequestBody Role role) {
        return roleService.update(role);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Role delete(@PathVariable(value = "id") String inputId) {
        return roleService.delete(Long.parseLong(inputId));
    }
}