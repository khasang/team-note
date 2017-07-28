package io.khasang.teamnote.db.dao;

import io.khasang.teamnote.model.Cat;

import java.util.List;

/**
 * @author gothmog on 28.07.2017.
 */
public interface CatDao {
    void createCat(Cat cat);

    void updateCat(Cat cat);

    void deleteCat(int id);

    List<Cat> getAllCats();

    Cat getCatById(int id);
}
