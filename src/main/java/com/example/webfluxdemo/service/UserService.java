package com.example.webfluxdemo.service;


import com.example.webfluxdemo.model.User;
import com.example.webfluxdemo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public Mono<ServerResponse> selectUsers(ServerRequest request) {
        return ServerResponse.ok().body(userDao.selectUsers(), User.class);
    }

    public Mono<ServerResponse> selectUser(ServerRequest request) {
        return userDao.selectUser(request.pathVariable("id"))
                .flatMap(user -> ServerResponse.ok().body(Mono.just(user), User.class))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

}