package com.thoughtworks.traing.chensen.todoservice.controller;

import com.thoughtworks.traing.chensen.todoservice.model.User;
import com.thoughtworks.traing.chensen.todoservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResponseEntity addToDo(@RequestBody User user) {
        return userService.add(user);
    }


    @GetMapping("/users")
    public List<User> todo() throws IOException {
        return userService.getUsers();
    }
}
