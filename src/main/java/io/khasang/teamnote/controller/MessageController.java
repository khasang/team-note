package io.khasang.teamnote.controller;

import io.khasang.teamnote.entity.Message;
import io.khasang.teamnote.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/message")
public class MessageController {
    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Message addMessage(@RequestBody Message message) {
        return messageService.addMessage(message);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Message> getMessages(){
        return messageService.getList();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Message getById(@PathVariable(value = "id") String inputId){
        return messageService.getById(Long.parseLong(inputId));
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Message update(@RequestBody Message message){
        return messageService.update(message);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Message delete(@PathVariable(value = "id") String inputId){
        return messageService.delete(Long.parseLong(inputId));
    }
}
