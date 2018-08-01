package com.thoughtworks.traing.chensen.todoservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.traing.chensen.todoservice.model.TodoInfo;
import com.thoughtworks.traing.chensen.todoservice.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.xml.soap.MimeHeaders;
import java.io.IOException;
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

    @GetMapping("/todos/{id}")
    public TodoInfo find(@PathVariable Integer id) {
        return toDoService.find(id);
    }

    @PostMapping("/todos")
    public void addToDo(@RequestBody TodoInfo todoInfo) {
        toDoService.add(todoInfo);
    }

//    @PostMapping("/todos")
//    public void updateToDo(TodoInfo todoInfo) {
//        toDoService.update(todoInfo);
//    }

    @DeleteMapping("/todos/{id}")
    public void updateToDo(@PathVariable Integer id) {
        toDoService.delete(id);
    }

    @GetMapping("/todos")
    public List<TodoInfo> todo() throws IOException {
//        List<TodoInfo> todoInfos = toDoService.getToDos();
//        return todoInfos;

//        ObjectMapper objectMapper = new ObjectMapper();
//        System.out.println("toDoService.getToDos()" + toDoService.getToDos());
//        List<TodoInfo> list = objectMapper.readValue(toDoService.getToDos(), new TypeReference<List<TodoInfo>>(){});
        return toDoService.getToDos();
    }
}
