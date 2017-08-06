package io.khasang.teamnote.dao.impl;

import io.khasang.teamnote.dao.StatusDao;
import io.khasang.teamnote.entity.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author gothmog on 06.08.2017.
 */
public class StatusDaoImpl extends BasicDaoImpl<Status> implements StatusDao{

    public StatusDaoImpl(Class<Status> entityClass) {
        super(entityClass);
    }
}
