package io.khasang.teamnote.dao;

import io.khasang.teamnote.entity.Task;

import java.util.List;

public interface TaskDao extends BasicDao<Task> {
    /**
      Returns a (@link List<Task>) with a given tasks by executor
     @param executorId
     @return List<Task>
    */
    public List<Task> getTasksByExecutor(String executorId);

    /**
     Returns a (@link List<Task>) with a given tasks by creator
     @param creatorId
     @return List<Task>
     */
    public List<Task> getTasksByCreator(long creatorId);
}
