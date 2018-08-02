package com.thoughtworks.traing.chensen.todoservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.traing.chensen.todoservice.model.TodoInfo;
import com.thoughtworks.traing.chensen.todoservice.model.User;
import com.thoughtworks.traing.chensen.todoservice.service.ToDoService;
import com.thoughtworks.traing.chensen.todoservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class UserApi {

    @Autowired
    private UserService userService;

    @GetMapping("/users/{id}")
    public User find(@PathVariable Integer id) {
        return userService.find(id);
    }

    @PostMapping("/users")
    public void addToDo(@RequestBody User user) {
        userService.add(user);
    }

    @DeleteMapping("/users/{id}")
    public void updateToDo(@PathVariable Integer id) {
        userService.delete(id);
    }

    @GetMapping("/users")
    public List<User> todo() throws IOException {
        return userService.getUsers();
    }
}
