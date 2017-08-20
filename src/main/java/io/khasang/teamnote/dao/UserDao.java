/**
 * 
 */
package io.khasang.teamnote.dao;

import java.util.List;

import io.khasang.teamnote.entity.User;

/**
 * Provides methods to create, delete, find {@link User} entities by different
 * attributes.
 * 
 * 
 * @author MickeyMouse
 *
 */
public interface UserDao extends BasicDao<User> {

	/**
	 * Returns a {@link User} with a given account name or null if such user not
	 * found.
	 * 
	 * @param accountName
	 * @return
	 */
	User getByAccountName(String accountName);

	/**
	 * Returns a {@link User} with a given email address or null if such user
	 * not found.
	 * 
	 * @param email
	 * @return
	 */
	User getByEmail(String email);

	/**
	 * Returns a list of all {@link User}s with a given first and last names.
	 * Many users can have the same first and last name. That is why this method
	 * can return more than one {@link User}.
	 * 
	 * @param firstName
	 * @param lastName
	 * @return
	 */
	List<User> getByPersonName(String firstName, String lastName);

}
