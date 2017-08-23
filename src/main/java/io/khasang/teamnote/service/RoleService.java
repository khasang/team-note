package io.khasang.teamnote.service;


import io.khasang.teamnote.entity.Role;
import java.util.List;

public interface RoleService {
    /**
     * Add role to DB
     *
     * @param role - role for creation
     * @return created role
     */
    Role addRole(Role role);
    /**
     * Find role at database
     *
     * @param id = uniq id at db for specific role
     * @return role
     */
    Role getById(long id);
    /**
     * Delete role from DB
     *
     * @param id = uniq id role from DB
     * @return deleted role
     */
    Role delete(long id);
    /**
     * Receive all roles by specific type
     *
     * @return list of roles
     */
    List<Role> getList();
    /**
     * Update specify role
     *
     * @param role = role for update
     * @return updated role
     */
    Role update(Role role);
}