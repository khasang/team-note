package io.khasang.teamnote.controller;

import io.khasang.teamnote.entity.Status;
import io.khasang.teamnote.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author gothmog on 06.08.2017.
 */
@Controller
@RequestMapping(value = "/status")
public class StatusController {
    @Autowired
    private StatusService statusService;

    @RequestMapping(value = "/add", method = RequestMethod.PUT, produces = "application/json; charset=utf-8")
    @ResponseBody
    public Status addStatus(@RequestBody Status status){
        return statusService.addStatus(status);
    }
}
