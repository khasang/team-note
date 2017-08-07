package io.khasang.teamnote.dao.impl;

import io.khasang.teamnote.dao.AuthorizationDao;
import io.khasang.teamnote.entity.Authorization;

public class AuthorizationDaoImpl extends BasicDaoImpl<Authorization> implements AuthorizationDao {

    public AuthorizationDaoImpl(Class<Authorization> entityClass) {
        super(entityClass);
    }
}
