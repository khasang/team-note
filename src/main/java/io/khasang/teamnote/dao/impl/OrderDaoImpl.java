package io.khasang.teamnote.dao.impl;

import io.khasang.teamnote.dao.OrderDao;
import io.khasang.teamnote.entity.Order;

public class OrderDaoImpl extends BasicDaoImpl<Order> implements OrderDao {

    public OrderDaoImpl(Class<Order> entityClass) {
        super(entityClass);
    }
}
