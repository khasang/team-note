package io.khasang.teamnote.service;

import io.khasang.teamnote.entity.Authorization;

import java.util.List;

public interface AuthorizationService {
    /**
     * Add authorization to DB
     *
     * @param authorization - authorization for creation
     * @return created authorization
     */
    Authorization addAuthorization(Authorization authorization);

    /**
     * Find authorization at database
     *
     * @param id = uniq id at db for specific authorization
     * @return authorization
     */
    Authorization getById(long id);

    /**
     * Delete authorization from DB
     *
     * @param id = uniq id authorization from DB
     * @return deleted authorization
     */
    Authorization delete(long id);

    /**
     * Receive all authorization by specific type
     *
     * @return list from authorization
     */
    List<Authorization> getList();
}
