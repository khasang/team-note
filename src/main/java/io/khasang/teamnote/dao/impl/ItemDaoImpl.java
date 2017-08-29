package io.khasang.teamnote.dao.impl;

import io.khasang.teamnote.dao.ItemDao;
import io.khasang.teamnote.entity.Item;

public class ItemDaoImpl extends BasicDaoImpl<Item> implements ItemDao {
    public ItemDaoImpl(Class<Item> entityClass) {
        super(entityClass);
    }
}
