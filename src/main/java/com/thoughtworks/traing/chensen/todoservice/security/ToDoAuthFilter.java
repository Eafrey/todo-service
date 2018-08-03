package com.thoughtworks.traing.chensen.todoservice.security;

import com.google.common.collect.ImmutableList;
import com.google.common.net.HttpHeaders;
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
import java.util.Collections;

@Component
public class ToDoAuthFilter extends OncePerRequestFilter {
    @Autowired
    private UserService userService;

    public static final byte[] SECRET_KEY = "kitty".getBytes();


    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        if(!StringUtils.isEmpty(token)) {
            Claims body = Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token)
                    .getBody();

            String userName = (String) body.get("userName");
            String pasword = (String) body.get("password");

            int id = (int) body.get("id");
            UserService.curLogedId = id;


            if (userService.verfiy(userName, pasword)) {
                SecurityContextHolder.getContext().setAuthentication(
                        new UsernamePasswordAuthenticationToken(userName, null,
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
