package io.khasang.teamnote.controller;

import io.khasang.teamnote.entity.Authorization;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AuthorizationServiceIntegrationTest {
    private final String ROOT = "http://localhost:8080/authorization";
    private final String ADD = "/add";
    private final String GET = "/get";
    private final String ALL = "/all";
    private final String DELETE = "/delete";

    @Test
    public void addAuthorizationAndGet() {
        Authorization authorization = createAuthorization();

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Authorization> responseEntity = restTemplate.exchange(
                ROOT + GET + "/{id}",
                HttpMethod.GET,
                null,
                Authorization.class,
                authorization.getId()
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        Authorization resultAuthorization = responseEntity.getBody();
        assertEquals(authorization.getSession(), resultAuthorization.getSession());
        deleteAuthorization(resultAuthorization.getId());
    }

    @Test
    public void getAllDocuments() {
        RestTemplate restTemplate = new RestTemplate();

        Authorization authorizationFirst = createAuthorization();
        Authorization authorizationSecond = createAuthorization();
        Authorization authorizationThird = createAuthorization();

        ResponseEntity<List<Authorization>> responseEntity = restTemplate.exchange(
                ROOT + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Authorization>>() {
                }
        );

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        List<Authorization> resultList = responseEntity.getBody();
        assertNotNull(resultList);
        deleteAuthorization(authorizationFirst.getId());
        deleteAuthorization(authorizationSecond.getId());
        deleteAuthorization(authorizationThird.getId());
    }

    private Authorization createAuthorization() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Authorization authorization = prefillAuthorization();

        HttpEntity<Authorization> httpEntity = new HttpEntity<>(authorization, headers);
        RestTemplate template = new RestTemplate();

        Authorization result = template.exchange(
                ROOT + ADD,
                HttpMethod.PUT,
                httpEntity,
                Authorization.class).getBody();

        assertNotNull(result);
        assertEquals(333, result.getUserId());
        assertEquals("Session №333", result.getSession());
        assertNotNull(result.getId());
        return result;
    }

    private Authorization prefillAuthorization() {
        return new Authorization(333, "Session №333");
    }

    private void deleteAuthorization(long id) {
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
