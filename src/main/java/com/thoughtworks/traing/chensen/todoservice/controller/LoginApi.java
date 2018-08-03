package com.thoughtworks.traing.chensen.todoservice.controller;

import com.thoughtworks.traing.chensen.todoservice.model.User;
import com.thoughtworks.traing.chensen.todoservice.service.ToDoService;
import com.thoughtworks.traing.chensen.todoservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginApi {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody User user) {
        return userService.login(user);
    }
}
