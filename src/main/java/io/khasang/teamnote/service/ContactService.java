package io.khasang.teamnote.service;

import io.khasang.teamnote.entity.Contact;

import java.util.List;


public interface ContactService {
    List<Contact> getContacts();
    List<Contact> getContactsWithDetail();
}
