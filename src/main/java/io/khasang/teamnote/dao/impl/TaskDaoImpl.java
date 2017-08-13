package io.khasang.teamnote.dao.impl;

import io.khasang.teamnote.dao.TaskDao;
import io.khasang.teamnote.entity.Task;

import javax.transaction.Transactional;

@Transactional
public class TaskDaoImpl extends BasicDaoImpl<Task> implements TaskDao {
    public TaskDaoImpl(Class<Task> entityClass) {
        super(entityClass);
    }
}
