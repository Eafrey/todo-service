package com.thoughtworks.traing.chensen.todoservice.security;

import com.google.common.collect.ImmutableList;
import com.google.common.net.HttpHeaders;
import com.thoughtworks.traing.chensen.todoservice.model.User;
import com.thoughtworks.traing.chensen.todoservice.service.ToDoService;
import com.thoughtworks.traing.chensen.todoservice.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.thymeleaf.util.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Optional;

@Component
public class ToDoAuthFilter extends OncePerRequestFilter {
    @Autowired
    private UserService userService;


    protected static final byte[] SECRET_KEY = "kitty".getBytes(Charset.defaultCharset());


    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (!StringUtils.isEmpty(token)) {
            Claims body = Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token)
                    .getBody();

            int id = (int) body.get("id");
            UserService.curLogedId = id;

            Optional<User> user = userService.findById(id);

            if (user.isPresent()) {
                SecurityContextHolder.getContext().setAuthentication(
                        new UsernamePasswordAuthenticationToken(user.get().getUserName(), null,
                                ImmutableList.of(new SimpleGrantedAuthority("admin"),
                                        new SimpleGrantedAuthority("role")))
                );
            }
        }

//        SecurityContextHolder.getContext().setAuthentication(
//                new UsernamePasswordAuthenticationToken("user", null,
//                        ImmutableList.of(new SimpleGrantedAuthority("admin"),
//                                new SimpleGrantedAuthority("role")))
//        );

        filterChain.doFilter(request, response);
    }

}
