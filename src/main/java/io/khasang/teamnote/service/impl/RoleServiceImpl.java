package io.khasang.teamnote.service.impl;

import io.khasang.teamnote.dao.RoleDao;
import io.khasang.teamnote.entity.Role;
import io.khasang.teamnote.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public Role addRole(Role role) {
        return roleDao.create(role);
    }

    @Override
    public Role getById(long id) {
        return roleDao.getById(id);
    }

    @Override
    public Role delete(long id) {
        Role roleForDelete = roleDao.getById(id);
        return roleDao.delete(roleForDelete);
    }

    @Override
    public List<Role> getList() {
        return roleDao.getList();
    }

    @Override
    public Role update(Role role) {
        return roleDao.update(role);
    }
}
