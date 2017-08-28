package io.khasang.teamnote.dao.impl;

import io.khasang.teamnote.dao.ItemsDao;
import io.khasang.teamnote.entity.Items;
import org.springframework.stereotype.Repository;

/**
 * @author gothmog on 29.08.2017.
 */
public class ItemsDaoImpl extends BasicDaoImpl<Items> implements ItemsDao{

    public ItemsDaoImpl(Class<Items> entityClass) {
        super(entityClass);
    }
}
