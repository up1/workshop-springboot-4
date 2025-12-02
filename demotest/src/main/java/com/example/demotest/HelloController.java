package com.example.demotest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public Message sayHi(){
        return new Message("Hello Testing with Spring Boot 4.0.0");
    }

}


record Message(String message){}
