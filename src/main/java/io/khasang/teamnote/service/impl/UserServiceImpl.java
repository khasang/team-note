package io.khasang.teamnote.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.khasang.teamnote.dao.UserDao;
import io.khasang.teamnote.entity.User;
import io.khasang.teamnote.service.UserService;

/**
 * Implementation of the service {@link UserService} that provides operations on {@link User} entity.
 * 
 * @author MickeyMouse
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User addUser(User user) {
		return userDao.create(user);
	}

	@Override
	public User delete(long id) {
		User userForDelete = userDao.getById(id);
		return userDao.delete(userForDelete);
	}

	@Override
	public List<User> getAll() {
		return userDao.getList();
	}

	@Override
	public User getById(long id) {
		return userDao.getById(id);
	}

	@Override
	public User update(User user) {
		return userDao.update(user);
	}

	@Override
	public User getByAccountName(String accountName) {
		return userDao.getByAccountName(accountName);
	}

	@Override
	public User getByEmail(String email) {
		return userDao.getByEmail(email);
	}

	@Override
	public List<User> getByPersonName(String firstName, String lastName) {
		return userDao.getByPersonName(firstName, lastName);
	}

}
