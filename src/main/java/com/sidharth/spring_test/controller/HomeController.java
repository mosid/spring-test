package com.sidharth.spring_test.controller;

import com.sidharth.spring_test.service.GreetingsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    private final GreetingsService greetingsService;

    public HomeController(GreetingsService greetingsService) {
        this.greetingsService = greetingsService;
    }

    @RequestMapping("/")
    public @ResponseBody String greeting() {
        return greetingsService.greet();
    }
}
