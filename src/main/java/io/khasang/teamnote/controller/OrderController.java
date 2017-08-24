package io.khasang.teamnote.controller;

import io.khasang.teamnote.entity.Order;
import io.khasang.teamnote.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/order")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Order addOrder(@RequestBody Order order) {
        return orderService.addOrder(order);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Order> getOrders(){
        return orderService.getList();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Order getById(@PathVariable(value = "id") String inputId){
        return orderService.getById(Long.parseLong(inputId));
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Order update(@RequestBody Order order){
        return orderService.updateOrder(order);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Order delete(@PathVariable(value = "id") String inputId){
        return orderService.delete(Long.parseLong(inputId));
    }
}

