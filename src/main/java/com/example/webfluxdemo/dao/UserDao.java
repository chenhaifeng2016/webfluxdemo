package com.example.webfluxdemo.dao;

import java.util.Arrays;
import java.util.List;

import com.example.webfluxdemo.model.User;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class UserDao {

    private final List<User> users = Arrays.asList(new User(1L, "User1"), new User(2L, "User2"));

    public Mono<User> selectUser(String id) {

        return Mono.justOrEmpty(users.stream().filter(user -> {
            return user.getUserID().equals(Long.valueOf(id));
        }).findFirst().orElse(null));
    }

    public Flux<User> selectUsers() {
        return Flux.fromIterable(users);
    }

}