package com.thoughtworks.traing.chensen.todoservice.service;

import com.thoughtworks.traing.chensen.todoservice.model.TodoInfo;
import com.thoughtworks.traing.chensen.todoservice.model.User;
import com.thoughtworks.traing.chensen.todoservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User find(Integer id) {
        return Optional.ofNullable(userRepository.findOne(id))
                .orElseThrow(null);
    }

    public void add(User user) {
        userRepository.save(user);
    }

    public void delete(Integer id) {
        userRepository.delete(id);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
