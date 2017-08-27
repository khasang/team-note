package io.khsasang.teamnote.controller;

import io.khasang.teamnote.entity.Task;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TaskControllerIntegrationTest {
    private final String ROOT   = "http://localhost:8080/task";
    private final String ADD    = "/add";
    private final String GET    = "/get";
    private final String ALL    = "/all";
    private final String DELETE = "/delete";
    private final String UPDATE = "/update";

    @Test
    public void addTaskAndGet() {
        Task task = createTask();
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Task> responseEntity = restTemplate.exchange(
                ROOT + GET + "/{id}",
                HttpMethod.GET,
                null,
                Task.class,
                task.getId()
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        Task result = responseEntity.getBody();
        assertEquals(task.getName(), result.getName());
        deleteTask(result.getId());

    }

    @Test
    public void getAllTasks() {
        RestTemplate restTemplate = new RestTemplate();

        Task firstTask = createTask();
        Task secondTask = createTask();

        ResponseEntity<List<Task>> responseEntity = restTemplate.exchange(
                ROOT + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Task>>() {
                }
        );

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        List<Task> resultList = responseEntity.getBody();
        assertNotNull(resultList);
        deleteTask(firstTask.getId());
        deleteTask(secondTask.getId());
    }

    @Test
    public void updateTask() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Task firstTask = createTask();
        firstTask.setName("updatedName");
        firstTask.setDescription("updatedDescription");
        HttpEntity<Task> httpEntity = new HttpEntity<>(firstTask, headers);

        RestTemplate template = new RestTemplate();
        Task result = template.exchange(
                ROOT + UPDATE,
                HttpMethod.POST,
                httpEntity,
                Task.class).getBody();

        assertNotNull(result);
        assertEquals("updatedName", result.getName());
        assertNotNull(result.getId());
        deleteTask(firstTask.getId());
    }

    private void deleteTask(long id) {
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

    private Task createTask() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Task task = prefillTask();

        HttpEntity<Task> httpEntity = new HttpEntity<>(task, headers);
        RestTemplate template = new RestTemplate();

        Task result = template.exchange(
                ROOT + ADD,
                HttpMethod.PUT,
                httpEntity,
                Task.class).getBody();

        assertNotNull(result);
        assertEquals("taskName", result.getName());
        assertNotNull(result.getId());

        return result;
    }

    private Task prefillTask() {
        Task task = new Task();
        task.setUserIdCreator(1);
        task.setUserIdExecutor(2);
        task.setStatusId(1);
        task.setPriorityId(1);
        task.setLableId(1);
        task.setName("taskName");
        task.setDescription("someting");
        task.setCreationDate(LocalDateTime.now());
        task.setIssueDate(LocalDateTime.now().plusDays(7));
        task.setEstimatedDate(LocalDateTime.now().plusDays(14));
        task.setUpdatedDate(LocalDateTime.now());
        task.setColor("red");
        return task;
    }
}
