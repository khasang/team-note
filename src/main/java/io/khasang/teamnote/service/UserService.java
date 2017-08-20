package io.khasang.teamnote.service;

import java.util.List;

import io.khasang.teamnote.entity.User;

public interface UserService {

	/**
	 * Adds user to database.
	 *
	 * @param user
	 *            user to add
	 * @return created user
	 */
	User addUser(User user);

	/**
	 * Deletes user from database.
	 *
	 * @param id
	 *            user ID
	 * @return deleted user
	 */
	User delete(long id);

	/**
	 * Receives all users from database.
	 *
	 * @return all users from database
	 */
	List<User> getAll();

	/**
	 * Finds user in database.
	 *
	 * @param id
	 *            user ID
	 * @return user
	 */
	User getById(long id);

	/**
	 * Updates specific user in database.
	 *
	 * @param user
	 *            user to update
	 * @return updated user
	 */
	User update(User user);

	/**
	 * Returns a {@link User} with a given account name or null if such user not
	 * found.
	 * 
	 * @param accountName
	 *            account name
	 * @return user with given account name or null
	 */
	User getByAccountName(String accountName);

	/**
	 * Returns a {@link User} with a given email address or null if such user
	 * not found.
	 * 
	 * @param email
	 *            E-Mail address
	 * @return user with given E-Mail address or null
	 */
	User getByEmail(String email);

	/**
	 * Returns a list of all {@link User}s with a given first and last names.
	 * Many users can have the same first and last name. That is why this method
	 * can return more than one {@link User}.
	 * 
	 * @param firstName
	 *            first name
	 * @param lastName
	 *            last name
	 * @return users having given first and last name
	 */
	List<User> getByPersonName(String firstName, String lastName);
}
