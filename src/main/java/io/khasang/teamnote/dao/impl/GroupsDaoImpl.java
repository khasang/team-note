package io.khasang.teamnote.dao.impl;

import io.khasang.teamnote.dao.GroupsDao;
import io.khasang.teamnote.entity.Groups;

public class GroupsDaoImpl extends BasicDaoImpl<Groups> implements GroupsDao {

    public GroupsDaoImpl(Class<Groups> entityClass) {
        super(entityClass);
    }
}
