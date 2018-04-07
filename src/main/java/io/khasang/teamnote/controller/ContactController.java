package io.khasang.teamnote.controller;

import io.khasang.teamnote.entity.Contact;

import io.khasang.teamnote.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/contacts")
public class ContactController {
    @Autowired
    ContactService contactService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Contact> getContacts() {
        return contactService.getContacts();
    }

    @RequestMapping(value = "/allWithDetail", method = RequestMethod.GET)
    @ResponseBody
    public List<Contact> getContactWithDetail(){return contactService.getContactsWithDetail();}
}
