package com.example.demotest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @GetMapping(value = "/hello", version = "1", produces = "application/json")
    public Message sayHi(){
        LOGGER.info("Called sayHi() of v1");
        return new Message("Hello Testing with Spring Boot 4.0.0 v1");
    }

    @GetMapping(value = "/hello", version = "2", produces = "application/json")
    public Message sayHi2(){
        LOGGER.info("Called sayHi() of v2");
        return new Message("Hello Testing with Spring Boot 4.0.0 v2");
    }
}


record Message(String message){}
