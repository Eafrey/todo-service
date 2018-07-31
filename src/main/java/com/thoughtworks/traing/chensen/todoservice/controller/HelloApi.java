package com.thoughtworks.traing.chensen.todoservice.controller;

import com.thoughtworks.traing.chensen.todoservice.model.Person;
import com.thoughtworks.traing.chensen.todoservice.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloApi {
    @Autowired
    private HelloService helloService;

    @RequestMapping(method = RequestMethod.GET,
            path = "/persons")
    public List<Person> hello() {
        return helloService.list();
    }
}
