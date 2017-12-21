package io.khasang.teamnote.controller;


import io.khasang.teamnote.entity.Role;
import io.khasang.teamnote.entity.Task;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
    public void addTaskAndGet(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        Task task = prepareTask();
        HttpEntity<Task> httpEntity = new HttpEntity(task,headers);

        RestTemplate restTemplate = new RestTemplate();

        Task result = restTemplate.exchange(
                ROOT+ADD,
                HttpMethod.PUT,
                httpEntity,
                Task.class
        ).getBody();
        assertNotNull(result);
        assertNotNull(result.getId());
        assertEquals(result.getName(),task.getName());
    }

    @Test
    public void getAllTasks(){
        RestTemplate restTemplate = new RestTemplate();
        Task first = addTask(prepareTask());
        Task second = addTask(prepareTask());
        ResponseEntity<List<Task>> responseEntity =  restTemplate.exchange(
                ROOT+ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Task>>() {
                }
        );
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        List<Task> resultList = responseEntity.getBody();
        assertNotNull(resultList);
    }

    private Task addTask(Task task){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);

        HttpEntity<Task> httpEntity = new HttpEntity<Task>(task,httpHeaders);
        Task result = restTemplate.exchange(
                ROOT+ADD,
                HttpMethod.PUT,
                httpEntity,
                Task.class
        ).getBody();
        return result;
    }

    private Task prepareTask(){
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
}
