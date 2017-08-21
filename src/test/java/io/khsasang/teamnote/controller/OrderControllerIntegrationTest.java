package io.khasang.teamnote.controller;

import io.khasang.teamnote.entity.Order;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class OrderControllerIntegrationTest {
    private final String ROOT = "http://localhost:8080/order";
    private final String ADD = "/add";
    private final String GET = "/get";
    private final String ALL = "/all";
    private final String DELETE = "/delete";
    private final String UPDATE = "/update";

    @Test
    public void addOrderAndGet() {
        Order order = createOrder();
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Order> responseEntity = restTemplate.exchange(
                ROOT + GET + "/{id}",
                HttpMethod.GET,
                null,
                Order.class,
                order.getId()
        );
        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        Order resultOrder = responseEntity.getBody();
        assertEquals(order.getPerson(), resultOrder.getPerson());
        deleteOrder(resultOrder.getId());
    }

    @Test
    public void getAllOrder() {
        RestTemplate restTemplate = new RestTemplate();

        Order firstOrder = createOrder();
        Order secondOrder = createOrder();

        ResponseEntity<List<Order>> responseEntity = restTemplate.exchange(
                ROOT + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Order>>() {
                }
        );

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        List<Order> resultList = responseEntity.getBody();
        assertNotNull(resultList);
        deleteOrder(firstOrder.getId());
        deleteOrder(secondOrder.getId());
    }

    private Order createOrder() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Order order = prefillOrder();

        HttpEntity<Order> httpEntity = new HttpEntity<>(order, headers);
        RestTemplate template = new RestTemplate();

        Order result = template.exchange(
                ROOT + ADD,
                HttpMethod.PUT,
                httpEntity,
                Order.class).getBody();

        assertNotNull(result);
        assertEquals("Student", result.getPerson());
        assertNotNull(result.getId());
        return result;
    }

    private Order prefillOrder() {
        Order order = new Order();
        order.setPerson("Student");
        order.setProduct("glass of water");
        order.setOrderNumber(2);
        order.setPrice(22.22);
        order.setOrderDate(new Date(Calendar.getInstance().getTimeInMillis()));
        return order;
    }

    private void deleteOrder(long id) {
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

    @Test
    public void updateOrderAndGet() {
        Order order = updateOrder();
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Order> responseEntity = restTemplate.exchange(
                ROOT + GET + "/{id}",
                HttpMethod.GET,
                null,
                Order.class,
                order.getId()
        );
        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        Order resultOrder = responseEntity.getBody();
        assertEquals(order.getPerson(), resultOrder.getPerson());
    }

    private Order updateOrder() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Order order = updatePrefillOrder();

        HttpEntity<Order> httpEntity = new HttpEntity<>(order, headers);
        RestTemplate template = new RestTemplate();

        Order result = template.exchange(
                ROOT + UPDATE,
                HttpMethod.POST,
                httpEntity,
                Order.class).getBody();

        assertNotNull(result);
        assertEquals("Student", result.getPerson());
        assertEquals("glass of water", result.getProduct());
        assertEquals(2, result.getOrderNumber());
        assertEquals(77.77, 77.77, 0.00);
        assertNotNull(result.getId());
        return result;
    }

    private Order updatePrefillOrder() {
        Order order = new Order();
        order.setId(5);
        order.setPerson("Student");
        order.setProduct("glass of water");
        order.setOrderNumber(2);
        order.setPrice(77.77);
        order.setOrderDate(new Date(Calendar.getInstance().getTimeInMillis() + 86400000  * 10));
        return order;
    }
}
