package io.khasang.teamnote.service.impl;

import io.khasang.teamnote.dao.StatusDao;
import io.khasang.teamnote.entity.Status;
import io.khasang.teamnote.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "statusService")
public class StatusServiceImpl implements StatusService{
    @Autowired
    private StatusDao statusDao;

    @Override
    public Status addStatus(Status status) {
        return statusDao.create(status);
    }

    @Override
    public Status getById(long id) {
        return statusDao.getById(id);
    }

    @Override
    public Status update(Status status) {
        return statusDao.update(status);
    }

    @Override
    public Status delete(long id) {
        Status statusForDelete = statusDao.getById(id);
        return statusDao.delete(statusForDelete);
    }

    @Override
    public List<Status> getList() {
        return statusDao.getList();
    }
}
