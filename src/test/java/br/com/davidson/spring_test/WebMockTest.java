package br.com.davidson.spring_test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.client.RestTestClient;

import static org.mockito.Mockito.when;

@WebMvcTest(GreetingController.class)
@AutoConfigureRestTestClient
public class WebMockTest {

    @Autowired
    private RestTestClient restTestClient;

    @MockitoBean
    private GreetingService greetingService;

    @Test
    void greetingShouldReturnDefaultMessage(){
        when(greetingService.greeting()).thenReturn("Hello, World!");
        restTestClient.get()
                .uri("/greeting")
                .exchange()
                .expectBody(String.class)
                .isEqualTo("Hello, World!");
    }
}
