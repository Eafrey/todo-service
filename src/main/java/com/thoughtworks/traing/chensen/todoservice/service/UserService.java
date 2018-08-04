package com.thoughtworks.traing.chensen.todoservice.service;

import com.thoughtworks.traing.chensen.todoservice.model.User;
import com.thoughtworks.traing.chensen.todoservice.repository.UserRepository;
import com.thoughtworks.traing.chensen.todoservice.security.ToDoAuthFilter;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    private UserRepository userRepository;
    public static int curLogedId;

    public User find(Integer id) {
        return Optional.ofNullable(userRepository.findOne(id))
                .orElseThrow(null);
    }

    public ResponseEntity add(User user) {
        Optional<User> user1 = userRepository.findByUserName(user.getUserName());
        if (user1.isPresent()) {
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        String password = user.getPassword();
        String encodePassword = encoder.encode(password);
        user.setPassword(encodePassword);
        userRepository.save(user);
        return ResponseEntity.ok("sign success");
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public boolean verfiy(String userName, String password) {
        Optional<User> user = userRepository.findByUserName(userName);
        if (user.isPresent()) {
//            return user.map(User::getPassword).filter(p -> p.equals(password)).isPresent();
            return user.map(User::getPassword)
                    .filter(p -> encoder.matches(password, p) || p.equals(password))
                    .isPresent();

        } else {
            return false;
        }
    }

    public ResponseEntity login(User user) {

        Map<String, Object> claims = new HashMap<>();
        String userName = user.getUserName();
        String password = user.getPassword();
        if (!verfiy(userName, password)) {
            return new ResponseEntity(HttpStatus.BAD_GATEWAY);
        }
        Optional<User> userInDB = userRepository.findByUserName(userName);

        claims.put("id", userInDB.get().getId());
        String token = Jwts.builder()
                .addClaims(claims)
                .signWith(SignatureAlgorithm.HS512, ToDoAuthFilter.SECRET_KEY)
                .compact();

        return ResponseEntity.ok(token);
    }

    public Optional<User> findById(int id) {
        return userRepository.findUserById(id);
    }
}
