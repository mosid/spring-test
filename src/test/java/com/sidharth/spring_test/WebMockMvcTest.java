package com.sidharth.spring_test;

import com.sidharth.spring_test.controller.HomeController;
import com.sidharth.spring_test.service.GreetingsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HomeController.class)
public class WebMockMvcTest {

    @Autowired
    private MockMvc mockMvc;

    // We use a @MockBean to create and inject a mock for the GreetingService
    // (If we do no tdo so then the application context cannot start)
    // and we set its expectations using Mockito
    @MockBean
    GreetingsService greetingsService;

    @Test
    void greetingShouldReturnMessageFromService() throws Exception {
        when(greetingsService.greet()).thenReturn("Hello, MockWorld!");
        mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("Hello, MockWorld!")));
    }
}

