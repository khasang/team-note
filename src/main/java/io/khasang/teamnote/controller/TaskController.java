package io.khasang.teamnote.controller;

import io.khasang.teamnote.entity.Task;
import io.khasang.teamnote.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/task")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @RequestMapping(
            value = "/add",
            method = RequestMethod.PUT,
            produces = "application/json; charset=utf-8")
    @ResponseBody
    public Task addTask(@RequestBody Task task){
        return taskService.addTask(task);
    }

    @RequestMapping(
            value = "/all",
            method = RequestMethod.GET)
    @ResponseBody
    public List<Task> getTasks(){
        return taskService.getList();
    }

    @RequestMapping(
            value = "/get/{id}",
            method = RequestMethod.GET)
    @ResponseBody
    public Task getById(@PathVariable(value = "id") String inputId){
        return taskService.getById(Long.parseLong(inputId));
    }

    @RequestMapping(
            value = "/update",
            method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseBody
    public Task update(@RequestBody Task task){
        return taskService.update(task);
    }

    @RequestMapping(
            value = "/delete/{id}",
            method = RequestMethod.DELETE)
    @ResponseBody
    public Task delete(@PathVariable(value = "id") String inputId){
        return taskService.delete(Long.parseLong(inputId));
    }

}
