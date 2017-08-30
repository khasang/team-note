package io.khasang.teamnote.service.impl;

import io.khasang.teamnote.dao.GroupsDao;
import io.khasang.teamnote.entity.Groups;
import io.khasang.teamnote.service.GroupsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("GroupsService")
public class GroupsServiceImpl implements GroupsService{

    @Autowired
    protected GroupsDao groupsDao;


    @Override
    public Groups addGroups(Groups groups) {
        return groupsDao.create(groups);
    }

    @Override
    public Groups getById(long id) {
        return groupsDao.getById(id);
    }

    @Override
    public Groups delete(long id) {
        Groups groupsForDelete = groupsDao.getById(id);
        return groupsDao.delete(groupsForDelete);
    }

    @Override
    public List<Groups> getList() {
        return groupsDao.getList();
    }

    @Override
    public Groups update(Groups groups) {
        return groupsDao.update(groups);
    }
}
