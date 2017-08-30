package io.khasang.teamnote.controller;

import io.khasang.teamnote.entity.Groups;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@Ignore
public class GroupsControllerIntergrationTest {
    private final String ROOT = "http://localhost:8080/groups";
    private final String ADD = "/add";
    private final String GET = "/get";
    private final String ALL = "/all";
    private final String DELETE = "/delete";
    private final String UPDATE = "/update";

    @Test
    public void addGroupsAndGet() {
        Groups groups = createGroups();

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Groups> responseEntity = restTemplate.exchange(
                ROOT + GET + "/{id}",
                HttpMethod.GET,
                null,
                Groups.class,
                groups.getId()
        );
        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        Groups resultGroups = responseEntity.getBody();
        assertEquals(groups.getGroupName(), resultGroups.getGroupName());
        deleteGroups(resultGroups.getId());
    }

    @Test
    public void getAllGroupss() {
        RestTemplate restTemplate = new RestTemplate();

        Groups firstGroups = createGroups();
        Groups secondGroups = createGroups();

        ResponseEntity<List<Groups>> responseEntity = restTemplate.exchange(
                ROOT + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Groups>>() {
                }
        );

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        List<Groups> resultList = responseEntity.getBody();
        assertNotNull(resultList);
        deleteGroups(firstGroups.getId());
        deleteGroups(secondGroups.getId());
    }

    @Test
    public void updateGroups(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Groups firstGroups  = createGroups();
        firstGroups.setGroupName("This is a new group name");

        HttpEntity<Groups> httpEntity = new HttpEntity<>(firstGroups, headers);
        RestTemplate template = new RestTemplate();

        Groups result = template.exchange(
                ROOT + UPDATE,
                HttpMethod.POST,
                httpEntity,
                Groups.class).getBody();

        assertNotNull(result);
        assertNotNull(result.getId());
        assertEquals("This is a new group name", result.getGroupName());

        deleteGroups(firstGroups.getId());
    }

    private Groups createGroups() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Groups groups = prefillGroups();

        HttpEntity<Groups> httpEntity = new HttpEntity<>(groups, headers);
        RestTemplate template = new RestTemplate();

        Groups result = template.exchange(
                ROOT + ADD,
                HttpMethod.PUT,
                httpEntity,
                Groups.class).getBody();

        assertNotNull(result);
        assertEquals("FamilyTest", result.getGroupName());
        assertNotNull(result.getId());
        return result;

    }

    private Groups prefillGroups() {
        Groups groups = new Groups();
        groups.setGroupName("FamilyTest");
        return groups;
    }

    private void deleteGroups(long id) {
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
