package io.khasang.teamnote.dao.impl;

import io.khasang.teamnote.dao.StatusDao;
import io.khasang.teamnote.entity.Status;

public class StatusDaoImpl extends BasicDaoImpl<Status> implements StatusDao{

    public StatusDaoImpl(Class<Status> entityClass) {
        super(entityClass);
    }
}

