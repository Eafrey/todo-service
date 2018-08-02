package com.thoughtworks.traing.chensen.todoservice.service;

import com.thoughtworks.traing.chensen.todoservice.model.TodoInfo;
import com.thoughtworks.traing.chensen.todoservice.model.User;
import com.thoughtworks.traing.chensen.todoservice.repository.UserRepository;
import com.thoughtworks.traing.chensen.todoservice.security.ToDoAuthFilter;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {

    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private UserRepository userRepository;

    public User find(Integer id) {
        return Optional.ofNullable(userRepository.findOne(id))
                .orElseThrow(null);
    }

    public void add(User user) {
        String password = user.getPassword();
        String encodePassword = bCryptPasswordEncoder.encode(password);
        user.setPassword(encodePassword);
        userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public boolean verfiy(String userName, String password) {
        Optional<User> user = userRepository.findByUserName(userName);
        if(user.isPresent()) {
//            return user.map(User::getPassword).filter(p -> p.equals(password)).isPresent();
            return user.map(User::getPassword).
                    filter(p -> bCryptPasswordEncoder.matches(password, p)).
                    isPresent();

        } else {
            return false;
        }
    }

    public String login(User user) {

        Map<String, Object> claims = new HashMap<>();
        claims.put("userName", user.getUserName());
        claims.put("password", user.getPassword());
        String token = Jwts.builder()
                .addClaims(claims)
//                .setExpiration(Date.from(Instant.now().minus(1, ChronoUnit.DAYS)))
                .signWith(SignatureAlgorithm.HS512, ToDoAuthFilter.SECRET_KEY)
                .compact();

        return token;
    }
}
