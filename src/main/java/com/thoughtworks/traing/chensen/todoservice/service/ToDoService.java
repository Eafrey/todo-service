package com.thoughtworks.traing.chensen.todoservice.service;

import com.thoughtworks.traing.chensen.todoservice.model.TodoInfo;
import com.thoughtworks.traing.chensen.todoservice.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ToDoService {
    
    @Autowired
    private ToDoRepository toDoRepository;


    public List<TodoInfo> getToDos() throws IOException {
//        return toDoRepository.list();
//        return toDoRepository.getListFromFile();
        return toDoRepository.findAll();
    }
}
