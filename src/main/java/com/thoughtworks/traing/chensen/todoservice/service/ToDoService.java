package com.thoughtworks.traing.chensen.todoservice.service;

import com.thoughtworks.traing.chensen.todoservice.model.TodoInfo;
import com.thoughtworks.traing.chensen.todoservice.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ToDoService {
    
    @Autowired
    private ToDoRepository toDoRepository;

    public List<TodoInfo> getToDos() throws IOException {
//        return toDoRepository.list();
//        return toDoRepository.getListFromFile();
        return toDoRepository.findAll();
    }

    @Transactional
    public TodoInfo find(Integer id) {
        return Optional.ofNullable(toDoRepository.findOne(id))
                .orElseThrow(null);
    }

    public void delete(Integer id) {
        toDoRepository.delete(id);
    }

    public void update(TodoInfo todoInfo) {
        toDoRepository.save(todoInfo);
    }

    public void add(TodoInfo todoInfo) {
        System.out.println("todoInfoBody"+todoInfo);
//        todoInfo.getTasks().stream().forEach(task -> {
//            task.setTodoInfo(todoInfo);
//        });
        System.out.println("todoInfoadd"+todoInfo);
        toDoRepository.save(todoInfo);
    }
}
