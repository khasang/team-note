package io.khasang.teamnote.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import io.khasang.teamnote.entity.User;
import io.khasang.teamnote.service.UserService;

/**
 * Connects REST calls (URLs) with the service {@link UserService}.
 * 
 * @author MickeyMouse
 */
@Controller
@RequestMapping(value = "/rest/users")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
	@ResponseBody
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<User> getAllUsers() {
		return userService.getAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public User getById(@PathVariable(value = "id") String userIdStr) {
		long userId = Long.parseLong(userIdStr);
		return userService.getById(userId);
	}

	@RequestMapping(method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@ResponseBody
	public User update(@RequestBody User user) {
		return userService.update(user);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public User delete(@PathVariable(value = "id") String userIdStr) {
		long userId = Long.parseLong(userIdStr);
		return userService.delete(userId);
	}

	@RequestMapping(value = "/accountName={accountName}", method = RequestMethod.GET)
	@ResponseBody
	public User getByAccountName(@PathVariable(value = "accountName") String accountName) {
		return userService.getByAccountName(accountName);
	}

	@RequestMapping(value = "/email={email}", method = RequestMethod.GET)
	@ResponseBody
	public User getByEmail(@PathVariable(value = "email") String email) {
		return userService.getByEmail(email);
	}

	@RequestMapping(value = "/firstName={firstName}&lastName={lastName}", method = RequestMethod.GET)
	@ResponseBody
	public List<User> getByPersonName(@PathVariable(value = "firstName") String firstName,
			@PathVariable(value = "lastName") String lastName) {
		return userService.getByPersonName(firstName, lastName);
	}
}
