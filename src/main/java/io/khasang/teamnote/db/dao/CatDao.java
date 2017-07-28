package io.khasang.teamnote.db.dao;

import io.khasang.teamnote.model.Cat;

import java.util.List;

/**
 * @author gothmog on 28.07.2017.
 */
public interface CatDao {
    boolean createCat(Cat cat);

    boolean updateCat(int id, String name);

    void deleteCat(int id);

    List<Cat> getAllCats();

    Cat  getCatById(int id);
}
