package io.khsasang.teamnote.controller;

import io.khasang.teamnote.entity.Status;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class StatusControllerIntegrationTest {
    private final String ROOT = "http://localhost:8080/status";
    private final String ADD = "/add";
    private final String GET = "/get";
    private final String ALL = "/all";
    private final String DELETE = "/delete";

    @Test
    public void addStatusAndGet() {
        Status status = createStatus();

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Status> responseEntity = restTemplate.exchange(
                ROOT + GET + "/{id}",
                HttpMethod.GET,
                null,
                Status.class,
                status.getId()
        );
        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        Status resultStatus = responseEntity.getBody();
        assertEquals(status.getName(), resultStatus.getName());
        deleteStatus(resultStatus.getId());
    }

    @Test
    public void getAllStatuses(){
        RestTemplate restTemplate = new RestTemplate();

        Status firstStatus = createStatus();
        Status secondStatus = createStatus();

        ResponseEntity<List<Status>> responseEntity = restTemplate.exchange(
                ROOT + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Status>>() {
                }
        );

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        List<Status> resultList = responseEntity.getBody();
        assertNotNull(resultList);
        deleteStatus(firstStatus.getId());
        deleteStatus(secondStatus.getId());
    }

    private Status createStatus() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Status status = prefillStatus();

        HttpEntity<Status> httpEntity = new HttpEntity<>(status, headers);
        RestTemplate template = new RestTemplate();

        Status result = template.exchange(
                ROOT + ADD,
                HttpMethod.PUT,
                httpEntity,
                Status.class).getBody();

        assertNotNull(result);
        assertEquals("statusName", result.getName());
        assertNotNull(result.getId());
        return result;
    }

    private Status prefillStatus() {
        Status status = new Status();
        status.setName("statusName");
        status.setDescription("something");
        return status;
    }

    private void deleteStatus(long id){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity =  restTemplate.exchange(
                ROOT + DELETE + "/{id}",
                HttpMethod.DELETE,
                null,
                String.class,
                id
        );
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }
}
