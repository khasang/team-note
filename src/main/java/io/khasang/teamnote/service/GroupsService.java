package io.khasang.teamnote.service;

import io.khasang.teamnote.entity.Groups;

import java.util.List;

public interface GroupsService {
    /**
     * Add groups to DB
     *
     * @param groups - groups for creation
     * @return created groups
     */
    Groups addGroups(Groups groups);

    /**
     * Find groups at database
     *
     * @param id = uniq id at db for specific groups
     * @return groups
     */
    Groups getById(long id);

    /**
     * Delete document from DB
     *
     * @param id = uniq id groups from DB
     * @return deleted groups
     */
    Groups delete(long id);

    /**
     * Receive all groupss by specific type
     *
     * @return list from groups
     */
    List<Groups> getList();

    /**
     * Update specify groups
     *
     * @param groups = groups for update
     * @return updated groups
     */
    Groups update(Groups groups);
}
