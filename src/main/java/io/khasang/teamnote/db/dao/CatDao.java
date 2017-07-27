package io.khasang.teamnote.db.dao;

import io.khasang.teamnote.model.Cat;

/**
 * @author gothmog on 28.07.2017.
 */
public interface CatDao {
    boolean createCat(Cat cat);

    boolean updateCat(int id, String name);

    void deleteCat(int id);
}
