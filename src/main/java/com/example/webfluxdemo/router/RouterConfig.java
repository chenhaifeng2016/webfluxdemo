package com.example.webfluxdemo.router;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;


import com.example.webfluxdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;

@Configuration
public class RouterConfig {

    @Autowired
    private UserService userService;

    //public RouterConfig(UserService userService) {
    //    this.userService = userService;
    //}

    @Bean
    public RouterFunction<?> routerFunction() {
        return
                route(GET("/api/v1/users").and(accept(MediaType.APPLICATION_JSON)), userService::selectUsers)
                        .and(route(GET("/api/v1/users/{id}").and(accept(MediaType.APPLICATION_JSON)), userService::selectUser));
//				.and(route(POST("/users"), userHandler::handleGetUsers));

    }

}