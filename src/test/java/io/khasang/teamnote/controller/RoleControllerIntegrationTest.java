package io.khasang.teamnote.controller;


import io.khasang.teamnote.entity.Role;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.Assert.*;

public class RoleControllerIntegrationTest {
    private final String ROOT = "http://localhost:8080/roles";
    private final String ADD = "/add";
    private final String GET = "/get";
    private final String ALL = "/all";
    private final String UPDATE = "/update";
    private final String DELETE = "/delete";

    @Test
    public void addRoleAndGet() {
        Role role = createRole();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Role> responseEntity = restTemplate.exchange(
                ROOT + GET + "/{id}",
                HttpMethod.GET,
                null,
                Role.class,
                role.getId()
        );
        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        Role result = responseEntity.getBody();
        assertEquals(role.getRoleName(), result.getRoleName());
        deleteRole(result.getId());
    }

    @Test
    public void getAllRoles() {
        RestTemplate restTemplate = new RestTemplate();
        Role firstRole = createRole();
        Role secondRole = createRole();
        ResponseEntity<List<Role>> responseEntity = restTemplate.exchange(
                ROOT + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Role>>() {
                }
        );
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        List<Role> resultList = responseEntity.getBody();
        assertNotNull(resultList);
        deleteRole(firstRole.getId());
        deleteRole(secondRole.getId());
    }

    @Test
    public void updateRole() {
        Role testRole = createRole();
        testRole.setRoleName("OK");
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Role> responseEntity = restTemplate.exchange(
                ROOT + UPDATE,
                HttpMethod.POST,
                new HttpEntity<>(testRole),
                Role.class
        );
        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        Role result = responseEntity.getBody();
        assertEquals(result.getRoleName(), "OK");
        deleteRole(testRole.getId());
    }

    @Test
    public void deleteRole() {
        Role testRole = createRole();
        assertNotNull(testRole);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Role> responseEntity = restTemplate.exchange(
                ROOT + DELETE + "/{id}",
                HttpMethod.DELETE,
                null,
                Role.class,
                testRole.getId()
        );
        Role result = responseEntity.getBody();
        assertNotNull(result);
        assertEquals(result.toString(), testRole.toString());
        ResponseEntity<Role> getEntity = restTemplate.exchange(
                ROOT + GET + "/{id}",
                HttpMethod.GET,
                null,
                Role.class,
                testRole.getId()
        );
        assertNull(getEntity.getBody());
    }

    private Role createRole() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        Role role = prepareRole();
        HttpEntity<Role> httpEntity = new HttpEntity<>(role, headers);
        RestTemplate template = new RestTemplate();
        Role result = template.exchange(
                ROOT + ADD,
                HttpMethod.PUT,
                httpEntity,
                Role.class).getBody();
        assertNotNull(result);
        assertEquals("roleName", result.getRoleName());
        assertNotNull(result.getId());
        return result;
    }

    private Role prepareRole() {
        Role role = new Role();
        role.setRoleName("roleName");
        role.setRoleDescription("someDescription");
        return role;
    }

    private void deleteRole(long id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                ROOT + DELETE + "/{id}",
                HttpMethod.DELETE,
                null,
                String.class,
                id
        );
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }
}