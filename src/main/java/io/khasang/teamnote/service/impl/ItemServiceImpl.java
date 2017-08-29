package io.khasang.teamnote.service.impl;

import io.khasang.teamnote.dao.ItemDao;
import io.khasang.teamnote.entity.Item;
import io.khasang.teamnote.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("itemService")
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemDao itemDao;

    @Override
    public Item addItem(Item item) {
        return itemDao.create(item);
    }

    @Override
    public Item getById(long id) {
        return itemDao.getById(id);
    }

    @Override
    public Item delete(long id) {
        Item itemForDelete = itemDao.getById(id);
        return itemDao.delete(itemForDelete);
    }

    @Override
    public List<Item> getList() {
        return itemDao.getList();
    }

    @Override
    public Item update(Item item) {
        return itemDao.update(update(item));
    }
}
