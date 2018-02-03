package io.khasang.teamnote.service.impl;

import io.khasang.teamnote.dao.ContactDao;
import io.khasang.teamnote.entity.Contact;
import io.khasang.teamnote.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService{

    @Autowired
    ContactDao contactDao;

    @Override
    public List<Contact> getContacts() {
        return contactDao.getList();
    }
}
