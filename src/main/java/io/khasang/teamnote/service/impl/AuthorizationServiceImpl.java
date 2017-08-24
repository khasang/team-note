package io.khasang.teamnote.service.impl;

import io.khasang.teamnote.dao.AuthorizationDao;
import io.khasang.teamnote.entity.Authorization;
import io.khasang.teamnote.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("authorizationService")
public class AuthorizationServiceImpl implements AuthorizationService {
    @Autowired
    AuthorizationDao authorizationDao;

    @Override
    public Authorization addAuthorization(Authorization authorization) {
        return authorizationDao.create(authorization);
    }

    @Override
    public Authorization getById(long id) {
        return authorizationDao.getById(id);
    }

    @Override
    public Authorization delete(long id) {
        Authorization authorizationForDelete = authorizationDao.getById(id);
        return authorizationDao.delete(authorizationForDelete);
    }

    @Override
    public List<Authorization> getList() {
        return authorizationDao.getList();
    }
}
