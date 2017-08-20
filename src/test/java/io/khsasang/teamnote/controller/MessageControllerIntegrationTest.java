package io.khsasang.teamnote.controller;

import io.khasang.teamnote.entity.Message;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MessageControllerIntegrationTest {
    private final String ROOT = "http://localhost:8080/message";
    private final String ADD = "/add";
    private final String GET = "/get";
    private final String ALL = "/all";
    private final String DELETE = "/delete";

    @Test
    public void addDocumentAndGet() {
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
        //deleteMessage(resultMessage.getId());
    }

    @Test
    public void getAllDocuments() {
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
        //deleteMessage(firstMessage.getId());
        //deleteMessage(secondMessage.getId());
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
        //message.setCreateData(LocalDateTime.now());
        System.out.println("Local dataTime " + LocalDateTime.now());
        message.setMessageText("some text");
        message.setPriority(1);
        message.setStatus(2);
        return message;
    }

    private void deleteMessage(long id){
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
