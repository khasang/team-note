package io.khasang.teamnote.service;

import io.khasang.teamnote.entity.Order;

import java.util.List;

public interface OrderService {
    /**
     * Add order to DB
     *
     * @param order - order for creation
     * @return created order
     */
    Order addOrder(Order order);

    /**
     * Find order at database
     *
     * @param id = uniq id at db for specific order
     * @return order
     */
    Order getById(long id);

    /**
     * Delete order from DB
     *
     * @param id = uniq id order from DB
     * @return deleted order
     */
    Order delete(long id);

    /**
     * Receive all orders by specific type
     *
     * @return list from order
     */
    List<Order> getList();

    /**
     * Update specify order
     *
     * @param order = order for update
     * @return updated order
     */
    Order update(Order order);
}
