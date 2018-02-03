package io.khasang.teamnote.dao.impl;

import io.khasang.teamnote.dao.ContactDao;
import io.khasang.teamnote.entity.Contact;


public class ContactDaoImpl extends BasicDaoImpl<Contact> implements ContactDao {
    public ContactDaoImpl(Class<Contact> entityClass) {
        super(entityClass);
    }


}
