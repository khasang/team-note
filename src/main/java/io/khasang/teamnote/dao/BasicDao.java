package io.khasang.teamnote.dao;

import org.hibernate.Session;

public interface BasicDao<T> {
    /**
     *
     * @return current Hibernate Session
     */
    Session getCurrentSession();

    /**
     * Create entity at database
     *
     * @param entity -current entity for creation
     * @return created entity
     */
    T create(T entity);
}
