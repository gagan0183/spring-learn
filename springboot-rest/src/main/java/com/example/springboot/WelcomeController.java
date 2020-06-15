package com.example.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @Autowired
    private WelcomeService welcomeService;

    @RequestMapping("/welcome")
    public String welcome() {
        return this.welcomeService.retreive();
    }
}
