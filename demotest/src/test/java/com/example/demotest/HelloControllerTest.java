package com.example.demotest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.TestRestTemplate;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureTestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.servlet.client.RestTestClient;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureTestRestTemplate
@AutoConfigureRestTestClient
class HelloControllerTest {


    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private RestTestClient restTestClient;

    @Test
    void sayHiWithTestRestTemplate() {
        var response = testRestTemplate.getForObject("/hello", Message.class);
        assertEquals("Hello Testing with Spring Boot 4.0.0", response.message());
    }

    @Test
    void sayHiWithRestTestClient() {
        restTestClient
                .get()
                .uri("/hello")
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectBody(Message.class)
                .isEqualTo(new Message("Hello Testing with Spring Boot 4.0.0"));
    }
}