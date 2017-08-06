package io.khasang.teamnote.service;

import io.khasang.teamnote.entity.Status;

/**
 * @author gothmog on 06.08.2017.
 */
public interface StatusService {
    /**
     *  Add status to DB
     *
     *  @param status - status for task
     * @return create status
     */
    Status addStatus(Status status);
}
