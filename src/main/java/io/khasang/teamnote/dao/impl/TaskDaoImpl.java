package io.khasang.teamnote.dao.impl;

import io.khasang.teamnote.dao.TaskDao;
import io.khasang.teamnote.entity.Task;

import java.util.ArrayList;
import java.util.List;


public class TaskDaoImpl extends BasicDaoImpl<Task> implements TaskDao {
    public TaskDaoImpl(Class<Task> entityClass) {
        super(entityClass);
    }



    @Override
    public List<Task> getTasksByExecutor(String executorId) {
        List<Task> taskList = new ArrayList<>();

        return null;
    }

    @Override
    public List<Task> getTasksByCreator(long creatorId) {
        return null;
    }
}
