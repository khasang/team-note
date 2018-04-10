package io.khasang.teamnote.service;

import io.khasang.teamnote.entity.Items;

import java.util.List;

/**
 * @author gothmog on 29.08.2017.
 */
public interface ItemsService {

    /**
     * Add items to DB
     *
     * @param items - items for creation
     * @return created items
     */
    Items addItems(Items items);

    /**
     * Find items at database
     *
     * @param id = uniq id at db for specific items
     * @return items
     */
    Items getById(long id);

    /**
     * Delete items from DB
     *
     * @param id = uniq id items from DB
     * @return deleted items
     */
    Items delete(long id);

    /**
     * Receive all items by specific type
     *
     * @return list from items
     */
    List<Items> getList();

    /**
     * Update specify items
     *
     * @param items = items for update
     * @return updated items
     */
    Items update(Items items);

    List<Items> findAllByItemsId(long id);
}
