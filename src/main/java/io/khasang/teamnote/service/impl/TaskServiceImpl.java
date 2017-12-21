package io.khasang.teamnote.service.impl;


import io.khasang.teamnote.dao.TaskDao;
import io.khasang.teamnote.entity.Task;
import io.khasang.teamnote.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("taskService")
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskDao taskDao;

    @Override
    public Task addTask(Task task) {
        return taskDao.create(task);
    }

    @Override
    public Task getById(long id) {
        return taskDao.getById(id);
    }

    @Override
    public Task delete(long id) {
        Task deletedTask = taskDao.getById(id);
        return taskDao.delete(deletedTask);
    }

    @Override
    public List<Task> getList() {
        return taskDao.getList();
    }

    @Override
    public List<Task> getByExecutor(long executorId) {
        return taskDao.getTasksByExecutor(executorId);
    }

    @Override
    public List<Task> getByCreator(long creatorId) {
        return taskDao.getTasksByCreator(creatorId);
    }

    @Override
    public Task update(Task task) {
        return taskDao.update(task);
    }
}
