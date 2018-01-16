package io.khasang.teamnote.controller;


import io.khasang.teamnote.entity.Task;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TaskControllerIntegrationTst {
    private final String ROOT = "http://localhost:8080/task";
    private final String ADD = "/new";
    private final String ALL = "/all";
    private final String GET_BY_ID = "/get/task";
    private final String GET_BY_EXECUTOR = "/executor";
    private final String GET_BY_CREATOR = "/creator";

    private final String UPDATE = "/update";
    private final String DELETE = "/delete";

    @Test
    public void addTaskAndGet() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        Task task = prepareTask();
        HttpEntity<Task> httpEntity = new HttpEntity(task, headers);

        RestTemplate restTemplate = new RestTemplate();

        Task result = restTemplate.exchange(
                ROOT + ADD,
                HttpMethod.PUT,
                httpEntity,
                Task.class
        ).getBody();
        assertNotNull(result);
        assertNotNull(result.getId());
        assertEquals(result.getName(), task.getName());

        deleteTask(result.getId());
    }

    @Test
    public void getAllTasks() {
        RestTemplate restTemplate = new RestTemplate();
        Task first = addGeneratedNewTask();
        Task second = addGeneratedNewTask();
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
        deleteTask(first.getId());
        deleteTask(second.getId());
    }

    @Test
    public void deleteTask() {
        Task t = addGeneratedNewTask();
        assertNotNull(t.getId());
        deleteTask(t.getId());
        assertNull(getTaskResponseById(t.getId()));
    }

    @Test
    public void updateTask() {
        Task task = addGeneratedNewTask();
        String newName = "qyerqwioeuyqiwoeuryoiqwiueiiwwqirio";
        task.setName(newName);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        HttpEntity<Task> taskEntity = new HttpEntity<>(task, headers);

        RestTemplate rt = new RestTemplate();
        rt.exchange(
                ROOT + UPDATE,
                HttpMethod.POST,
                taskEntity,
                Task.class
        );
        System.out.println(task.getId());
        Task updatedTask = getTaskResponseById(task.getId());
        System.out.println(updatedTask);
        assertNotNull(updatedTask.getName());
        assertEquals(updatedTask.getName(), newName);
        deleteTask(task.getId());
    }

    @Test
    public void getByExecutor() {
        List<Task> executorTasks = new ArrayList<Task>();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity httpEntity = new HttpEntity(executorTasks, headers);

        String nameExecutor = "testNameExecutor";

        RestTemplate rt = new RestTemplate();
        ResponseEntity<List<Task>> res = rt.exchange(
                ROOT + GET_BY_EXECUTOR + "/nameExecutor",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Task>>() {
                },
                nameExecutor
        );

        assertEquals(res.getBody().size(), 2);

    }

    private Task prepareTask() {
        Task task = new Task();
        task.setName("TestTask");
        task.setCreator("Me");
        task.setExecutor("AnyBody");
        task.setDescription("TEST Task!!!!!");
        task.setLabel("test Today");
        task.setStatus("important");
        task.setPriority(1);
        return task;
    }

    private Task addGeneratedNewTask() {
        Task task = prepareTask();
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);

        HttpEntity<Task> httpEntity = new HttpEntity<Task>(task, httpHeaders);
        Task result = restTemplate.exchange(
                ROOT + ADD,
                HttpMethod.PUT,
                httpEntity,
                Task.class
        ).getBody();
        return result;
    }

    private Task getTaskResponseById(long id) {
        RestTemplate rt = new RestTemplate();
        Task task;
        try {
            task = rt.exchange(
                    ROOT + GET_BY_ID + "/{id}",
                    HttpMethod.GET,
                    null,
                    Task.class,
                    id
            ).getBody();
            System.out.println(task);
        } catch (HttpClientErrorException e) {
            return null;
        }
        return task;
    }

    private String deleteTask(long id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> result = restTemplate.exchange(
                ROOT + DELETE + "/{id}",
                HttpMethod.DELETE,
                null,
                String.class,
                id
        );
        assertEquals(HttpStatus.OK, result.getStatusCode());
        return result.getBody();
    }
}
