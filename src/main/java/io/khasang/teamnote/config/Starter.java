package io.khasang.teamnote.config;

import io.khasang.teamnote.config.application.AppConfig;
import io.khasang.teamnote.dao.ContactDao;
import io.khasang.teamnote.entity.Contact;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Starter {
    public static void main(String[] args) {
        ApplicationContext apx = new AnnotationConfigApplicationContext(AppConfig.class);
        ContactDao contactDao = apx.getBean("contactDao",ContactDao.class);
        List<Contact> contacts = contactDao.findAllWithDetail();

    }
}
