package com.thoughtworks.traing.chensen.todoservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.traing.chensen.todoservice.model.TodoInfo;
import com.thoughtworks.traing.chensen.todoservice.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void onNotFoundException() {

    }

    @RequestMapping(method = RequestMethod.GET, path = "/todos_old")
    public String todo(Model model) {
        model.addAttribute("todos", toDoService.getToDos());
        return "todo";
    }


}
