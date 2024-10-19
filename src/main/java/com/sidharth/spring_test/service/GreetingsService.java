package com.sidharth.spring_test.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingsService {

    public String greet() {
        return "Hello, World!";
    }
}
