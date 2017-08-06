package io.khasang.teamnote.dao.impl;

import io.khasang.teamnote.dao.BasicDao;
import org.hibernate.Session;

/**
 * @author gothmog on 06.08.2017.
 */
public class BasicDaoImpl<T> implements BasicDao<T>{
    @Override
    public Session getCurrentSession() {
        return null;
    }

    @Override
    public T create(T entity) {
        return null;
    }
}
