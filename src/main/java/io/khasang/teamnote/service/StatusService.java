package io.khasang.teamnote.service;

import io.khasang.teamnote.entity.Status;
import java.util.List;

public interface StatusService {
    /**
     *  Add status to DB
     *
     *  @param status - status for task
     * @return create status
     */
    Status addStatus(Status status);

    /**
     * Find status at database
     * @param id = uniq id at database for status
     * @return status
     */
    Status getById(long id);

    /**
     *  Update status
     * @param status = status for update
     * @return updated status
     */
    Status update(Status status);

    /**
     * Delete status from Db
     * @param id = uniq id status from db
     * @return deleted status
     */
    Status delete(long id);

    /**
     * Receive all statuses by specific type
     * @return list from status
     */
    List<Status> getList();
}
