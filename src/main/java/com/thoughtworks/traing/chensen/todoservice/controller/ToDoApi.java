package com.thoughtworks.traing.chensen.todoservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.traing.chensen.todoservice.model.TodoInfo;
import com.thoughtworks.traing.chensen.todoservice.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ToDoApi {

    @Autowired
    private ToDoService toDoService;

    @Autowired
    private ObjectMapper objectMapper;

    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void onNotFoundException() {

    }

    @GetMapping("/todos")
    public List<TodoInfo> todo() throws JsonProcessingException {
        List<TodoInfo> todoInfos = toDoService.getToDos();
        return todoInfos;
    }
}
