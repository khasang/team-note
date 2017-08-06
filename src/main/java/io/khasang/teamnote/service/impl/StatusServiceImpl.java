package io.khasang.teamnote.service.impl;

import io.khasang.teamnote.dao.StatusDao;
import io.khasang.teamnote.entity.Status;
import io.khasang.teamnote.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author gothmog on 06.08.2017.
 */
@Service(value = "statusService")
public class StatusServiceImpl implements StatusService{
    @Autowired
    private StatusDao statusDao;

    @Override
    public Status addStatus(Status status) {
        return null;
    }
}
