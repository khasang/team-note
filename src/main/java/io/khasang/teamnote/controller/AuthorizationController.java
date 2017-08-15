package io.khasang.teamnote.controller;

import io.khasang.teamnote.entity.Authorization;
import io.khasang.teamnote.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/authorization")
public class AuthorizationController {
    private final AuthorizationService authorizationService;

    @Autowired
    public AuthorizationController(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Authorization addDocument(@RequestBody Authorization authorization) {
        return authorizationService.addAuthorization(authorization);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Authorization> getAuthorizations() {
        return authorizationService.getList();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Authorization getById(@PathVariable(value = "id") String inputId) {
        return authorizationService.getById(Long.valueOf(inputId));
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Authorization delete(@PathVariable(value = "id") String inputId) {
        return authorizationService.delete(Long.parseLong(inputId));
    }
}
