package io.khasang.teamnote.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * @author gothmog on 06.08.2017.
 */
public interface BasicDao<T> {
    Session getCurrentSession();

    T create(T entity);
}
