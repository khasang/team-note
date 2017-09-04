package io.khasang.teamnote.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import io.khasang.teamnote.entity.Document;
import io.khasang.teamnote.entity.Role;
import io.khasang.teamnote.entity.User;

public class UserControllerIntegrationTest {

	private final String USERS_ROOT_URL = "http://localhost:8080/rest/users";
	private final String ROLES_ADD_URL = "http://localhost:8080/roles/add";
	private final String ROLES_DELETE_URL = "http://localhost:8080/roles/delete";

	@Test
	public void addRoleToUser() {
		User user = createUser("Bill", "Clinton", "bill.clinton", "123", "bclinton@gmail.com");
		Role role = createRole("President", "USA President");

		try {
			RestTemplate restTemplate = new RestTemplate();

			ResponseEntity<User> responseEntity = restTemplate.exchange(USERS_ROOT_URL + "/{userId}/addRole/{roleId}",
					HttpMethod.POST, null, User.class, user.getId(), role.getId());

			assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
			User userResult = responseEntity.getBody();

			assertNotNull(userResult.getRoles());
			assertEquals(1, userResult.getRoles().size());

			Role roleResult = userResult.getRoles().get(0);
			assertEquals(role.getId(), roleResult.getId());

		} finally {
			deleteUser(user.getId());
			deleteRole(role.getId());
		}

	}

	@Test
	public void addUserAndGet() {
		// Create new user and save it to database
		User user = createUser("Bill", "Clinton", "bill.clinton", "123", "bclinton@gmail.com");
		assertNotNull(user.getId());

		RestTemplate restTemplate = new RestTemplate();

		// Load user by ID
		ResponseEntity<User> responseEntity = restTemplate.exchange(USERS_ROOT_URL + "/{id}", HttpMethod.GET, null,
				User.class, user.getId());
		assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
		User result = responseEntity.getBody();

		assertNotNull(result);

		// Check if all user fields were saved correctly
		assertEquals("Bill", result.getFirstName());
		assertEquals("Clinton", result.getLastName());
		assertEquals("bill.clinton", result.getAccountName());
		assertEquals("123", result.getPassword());
		assertEquals("bclinton@gmail.com", result.getEmail());

		deleteUser(result.getId());
	}

	private User createUser(String firstName, String lastName, String accountName, String password, String email) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		User user = prepareUser(firstName, lastName, accountName, password, email);
		HttpEntity<User> httpEntity = new HttpEntity<>(user, headers);
		RestTemplate template = new RestTemplate();
		User result = template.exchange(USERS_ROOT_URL, HttpMethod.PUT, httpEntity, User.class).getBody();
		return result;

	}

	private Role createRole(String name, String description) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		Role role = prepareRole(name, description);
		HttpEntity<Role> httpEntity = new HttpEntity<>(role, headers);
		RestTemplate template = new RestTemplate();
		Role result = template.exchange(ROLES_ADD_URL, HttpMethod.PUT, httpEntity, Role.class).getBody();
		return result;

	}

	private User prepareUser(String firstName, String lastName, String accountName, String password, String email) {
		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setAccountName(accountName);
		user.setPassword(password);
		user.setEmail(email);
		return user;
	}

	@Test
	public void getAllUsers() {
		RestTemplate restTemplate = new RestTemplate();

		User firstUser = createUser("Bill", "Clinton", "bill.clinton", "123", "bclinton@gmail.com");
		User secondUser = createUser("Donald", "Trump", "donald.trump", "567", "dtrump@yahoo.com");

		ResponseEntity<List<Document>> responseEntity = restTemplate.exchange(USERS_ROOT_URL, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Document>>() {
				});

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		List<Document> resultList = responseEntity.getBody();
		assertNotNull(resultList);
		deleteUser(firstUser.getId());
		deleteUser(secondUser.getId());
	}

	private void deleteUser(long id) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> responseEntity = restTemplate.exchange(USERS_ROOT_URL + "/{id}", HttpMethod.DELETE, null,
				String.class, id);

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

	private Role prepareRole(String name, String description) {
		Role role = new Role();
		role.setRoleName(name);
		role.setRoleDescription(description);
		return role;
	}

	private void deleteRole(long id) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> responseEntity = restTemplate.exchange(ROLES_DELETE_URL + "/{id}", HttpMethod.DELETE,
				null, String.class, id);

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}
}
