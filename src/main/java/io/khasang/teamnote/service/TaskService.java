package io.khasang.teamnote.service;

import io.khasang.teamnote.entity.Task;

import java.util.List;

public interface TaskService {
    /**
     * Add task to DB
     *
     * @param task - task for creation
     * @return created task
     */
    Task addTask(Task task);

    /**
     * Find ebtity at database
     * @param id = uniq id  at db for specific task
     * @return task
     */
    Task getById(long id);

    /**
     * Delete task from db
     * @param id = uniq id from db
     * @return deleted task
     */
    Task delete(long id);

    /**
     * Receive all entities by spicific type
     *
     * @return list from task
     */
    List<Task> getList();

    /**
     * Update specify task
     * @param task = task for update
     * @return updated task
     */
    Task update(Task task);
}
