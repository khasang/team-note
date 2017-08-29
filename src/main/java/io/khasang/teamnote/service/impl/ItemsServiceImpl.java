package io.khasang.teamnote.service.impl;

import io.khasang.teamnote.dao.ItemsDao;
import io.khasang.teamnote.entity.Items;
import io.khasang.teamnote.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gothmog on 29.08.2017.
 */
@Service("itemsService")
public class ItemsServiceImpl implements ItemsService {
    @Autowired
    private ItemsDao itemsDao;

    @Override
    public Items findById(long id) {
        return itemsDao.getById(id);
    }

    @Override
    public List<Items> findAll() {
        return itemsDao.getList();
    }

    @Override
    public List<Items> findAllByUserId(long id) {
        return itemsDao.findAllByUserId(id);
    }

    @Override
    public Items saveItems(Items items) {
        return itemsDao.create(items);
    }

    @Override
    public Items deleteById(long id) {
        Items itemsDelete = itemsDao.getById(id);
        return itemsDao.delete(itemsDelete);
    }
}
