package io.khasang.teamnote.service;

import io.khasang.teamnote.entity.Contact;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ContactService {
    public List<Contact> getContacts();
}
