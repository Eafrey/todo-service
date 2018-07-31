package com.thoughtworks.traing.chensen.todoservice.service;

import com.thoughtworks.traing.chensen.todoservice.model.TodoInfo;
import com.thoughtworks.traing.chensen.todoservice.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {
    
    @Autowired
    private ToDoRepository toDoRepository;


    public List<TodoInfo> getToDos() {
//        return toDoRepository.list();
        return toDoRepository.getListFromFile("/Users/senchen/CodeWorks/IDEAWorkSpace/Week3/todo-service/todo.json");
    }
}
