package io.khasang.teamnote.controller;

import io.khasang.teamnote.entity.Status;
import io.khasang.teamnote.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Frame RestService CRUD operation
 * @author gothmog on 06.08.2017.
 */
@Controller
@RequestMapping(value = "/status")
public class StatusController {
    private final StatusService statusService;

    @Autowired
    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.PUT, produces = "application/json; charset=utf-8")
    @ResponseBody
    public Status addStatus(@RequestBody Status status){
        return statusService.addStatus(status);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Status> getStatus(){
        return statusService.getList();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Status getById(@PathVariable(value = "id") String inputId){
        return statusService.getById(Long.parseLong(inputId));
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public Status update(@RequestBody Status status){
        return statusService.update(status);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Status delete(@PathVariable(value = "id") String inputId){
        return statusService.delete(Long.parseLong(inputId));
    }
}
