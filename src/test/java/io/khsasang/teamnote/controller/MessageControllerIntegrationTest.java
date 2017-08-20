package io.khsasang.teamnote.controller;

import io.khasang.teamnote.entity.Message;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MessageControllerIntegrationTest {
    private final String ROOT = "http://localhost:8080/message";
    private final String ADD = "/add";
    private final String GET = "/get";
    private final String ALL = "/all";
    private final String DELETE = "/delete";
    private final String UPDATE = "/update";

    @Test
    public void addMessageAndGet() {
        Message message = createMessage();

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Message> responseEntity = restTemplate.exchange(
                ROOT + GET + "/{id}",
                HttpMethod.GET,
                null,
                Message.class,
                message.getId()
        );
        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        Message resultMessage = responseEntity.getBody();
        assertEquals(message.getMessageText(), resultMessage.getMessageText());
        deleteMessage(resultMessage.getId());
    }

    @Test
    public void getAllMessages() {
        RestTemplate restTemplate = new RestTemplate();

        Message firstMessage = createMessage();
        Message secondMessage = createMessage();

        ResponseEntity<List<Message>> responseEntity = restTemplate.exchange(
                ROOT + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Message>>() {
                }
        );

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        List<Message> resultList = responseEntity.getBody();
        assertNotNull(resultList);
        deleteMessage(firstMessage.getId());
        deleteMessage(secondMessage.getId());
    }

    @Test
    public void updateMessage(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Message firstMessage  = createMessage();
        firstMessage.setMessageText("This is a new messageText");
        firstMessage.setPriority(10);


        HttpEntity<Message> httpEntity = new HttpEntity<>(firstMessage, headers);
        RestTemplate template = new RestTemplate();

        Message result = template.exchange(
                ROOT + UPDATE,
                HttpMethod.POST,
                httpEntity,
                Message.class).getBody();

        assertNotNull(result);
        assertNotNull(result.getId());
        assertEquals("This is a new messageText", result.getMessageText());
        assertEquals(10, result.getPriority());


        deleteMessage(firstMessage.getId());
    }

    private Message createMessage() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Message message = prefillMessage();

        HttpEntity<Message> httpEntity = new HttpEntity<>(message, headers);
        RestTemplate template = new RestTemplate();

        Message result = template.exchange(
                ROOT + ADD,
                HttpMethod.PUT,
                httpEntity,
                Message.class).getBody();

        assertNotNull(result);
        assertEquals("some text", result.getMessageText());
        assertNotNull(result.getId());
        return result;

    }

    private Message prefillMessage() {
        Message message = new Message();
        message.setFromUserId(10);
        message.setToUserId(10);
        message.setCreateTime(Calendar.getInstance().getTime().getTime());
        message.setMessageText("some text");
        message.setPriority(1);
        message.setStatus(2);
        return message;
    }

    private void deleteMessage(long id) {
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
