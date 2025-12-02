package com.example.demotest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping(value = "/hello", version = "1")
    public Message sayHi(){
        return new Message("Hello Testing with Spring Boot 4.0.0 v1");
    }

    @GetMapping(value = "/hello", version = "2")
    public Message sayHi2(){
        return new Message("Hello Testing with Spring Boot 4.0.0 v2 ");
    }

}


record Message(String message){}
