package io.khasang.teamnote.dao;

import org.hibernate.Session;

import java.util.List;

public interface BasicDao<T> {
    /**
     * @return current Hibernate Session
     */
    Session getCurrentSession();

    /**
     * Create entity at database
     *
     * @param entity - current entity for creation
     * @return created entity
     */
    T create(T entity);

    T getById(long id);

    T delete(T entity);

    List<T> getList();

    T update(T entity);
}
