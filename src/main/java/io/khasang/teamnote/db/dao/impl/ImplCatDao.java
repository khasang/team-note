package io.khasang.teamnote.db.dao.impl;

import io.khasang.teamnote.db.ImplDaoFactory;
import io.khasang.teamnote.db.dao.CatDao;
import io.khasang.teamnote.model.Cat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author gothmog on 28.07.2017.
 */
public class ImplCatDao implements CatDao {
    private static final Logger log = LoggerFactory.getLogger(ImplCatDao.class);
    private ImplDaoFactory daoFactory = new ImplDaoFactory();

    @Override
    public boolean createCat(Cat cat) {
        return false;
    }

    @Override
    public boolean updateCat(int id, String name) {
        return false;
    }

    @Override
    public void deleteCat(int id) {

    }
}
