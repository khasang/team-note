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

    /**
     * Find entity at database
     *
     * @param id = uniq id at db for specific entity
     * @return entity
     */
    T getById(long id);

    /**
     * Delete entity from DB
     *
     * @param entity = uniq entity from DB
     * @return deleted entity
     */
    T delete(T entity);

    /**
     * Receive all entities by specific type
     *
     * @return list from entity
     */
    List<T> getList();

    /**
     * Update specify entity
     *
     * @param entity = entity for update
     * @return updated entity
     */
    T update(T entity);
}
