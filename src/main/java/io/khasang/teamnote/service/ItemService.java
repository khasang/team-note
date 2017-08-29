package io.khasang.teamnote.service;

import io.khasang.teamnote.entity.Item;

import java.util.List;

public interface ItemService {
    /**
     * Add item to DB
     *
     * @param item - item for creation
     * @return created item
     */
    Item addItem(Item item);

    /**
     * Find item at database
     *
     * @param id = uniq id at db for specific item
     * @return item
     */
    Item getById(long id);

    /**
     * Delete item from DB
     *
     * @param id = uniq id item from DB
     * @return deleted item
     */
    Item delete(long id);

    /**
     * Receive all items by specific type
     *
     * @return list from item
     */
    List<Item> getList();

    /**
     * Update specify item
     *
     * @param item = item for updateItem
     * @return updated item
     */
    Item update(Item item);
}
