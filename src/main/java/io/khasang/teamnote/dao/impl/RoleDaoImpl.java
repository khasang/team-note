package io.khasang.teamnote.dao.impl;


import io.khasang.teamnote.dao.RoleDao;
import io.khasang.teamnote.entity.Role;

public class RoleDaoImpl extends BasicDaoImpl<Role> implements RoleDao {
    public RoleDaoImpl(Class<Role> entityClass) {
        super(entityClass);
    }
}
