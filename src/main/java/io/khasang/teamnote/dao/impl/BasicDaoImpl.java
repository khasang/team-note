package io.khasang.teamnote.dao.impl;

import io.khasang.teamnote.dao.BasicDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;


@Transactional
public class BasicDaoImpl<T> implements BasicDao<T> {
    private final Class<T> entityClass;

    @Autowired
    protected SessionFactory sessionFactory;

    public BasicDaoImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public T create(T entity) {
        getCurrentSession().save(entity);
        return entity;
    }
}
