package io.khasang.teamnote.dao;


import io.khasang.teamnote.entity.Contact;

import java.util.List;

public interface ContactDao{
    List<Contact> findAll();
    List<Contact> findAllWithDetail();
    Contact findById(Long id);
    Contact save(Contact contact);
    void delete(Contact contact);
}
