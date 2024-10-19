package com.sidharth.spring_test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

// The whole application is started along with the server
// This can be avoided by using Spring's MockMvc by using @AutoConfigureMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void greetingShouldReturnDefaultMessage() {
        assertThat(this.testRestTemplate.getForObject("http://localhost:" + port + "/", String.class)).contains("Hello, World!");
    }
}
