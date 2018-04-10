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
    public Items addItems(Items items) {
        return itemsDao.create(items);
    }

    @Override
    public Items getById(long id) {
        return itemsDao.getById(id);
    }

    @Override
    public Items delete(long id) {
        Items itemsForDelete = itemsDao.getById(id);
        return itemsDao.delete(itemsForDelete);
    }

    @Override
    public List<Items> getList() {
        return itemsDao.getList();
    }

    @Override
    public Items update(Items items) {
        return itemsDao.update(items);
    }

    @Override
    public List<Items> findAllByItemsId(long itemsId) {
        return itemsDao.findAllByItemsId(itemsId);
    }
}
