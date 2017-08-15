package io.khsasang.teamnote.controller;

import io.khasang.teamnote.entity.Document;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DocumentControllerIntegrationTest {
    private final String ROOT = "http://localhost:8080/document";
    private final String ADD = "/add";
    private final String GET = "/get";
    private final String ALL = "/all";
    private final String DELETE = "/delete";

    @Test
    public void addDocumentAndGet() {
        Document document = createDocument();

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Document> responseEntity = restTemplate.exchange(
                ROOT + GET + "/{id}",
                HttpMethod.GET,
                null,
                Document.class,
                document.getId()
        );
        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        Document resultDocument = responseEntity.getBody();
        assertEquals(document.getName(), resultDocument.getName());
        deleteDocument(resultDocument.getId());
    }

    @Test
    public void getAllDocuments() {
        RestTemplate restTemplate = new RestTemplate();

        Document firstDocument = createDocument();
        Document secondDocument = createDocument();

        ResponseEntity<List<Document>> responseEntity = restTemplate.exchange(
                ROOT + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Document>>() {
                }
        );

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        List<Document> resultList = responseEntity.getBody();
        assertNotNull(resultList);
        deleteDocument(firstDocument.getId());
        deleteDocument(secondDocument.getId());
    }

    private Document createDocument() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Document document = prefillDocument();

        HttpEntity<Document> httpEntity = new HttpEntity<>(document, headers);
        RestTemplate template = new RestTemplate();

        Document result = template.exchange(
                ROOT + ADD,
                HttpMethod.PUT,
                httpEntity,
                Document.class).getBody();

        assertNotNull(result);
        assertEquals("documentName", result.getName());
        assertNotNull(result.getId());
        return result;
    }

    private Document prefillDocument() {
        Document document = new Document();
        document.setName("documentName");
        document.setDescription("something");
        return document;
    }

    private void deleteDocument(long id){
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
