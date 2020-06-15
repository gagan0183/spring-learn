package com.example.springboot;

import org.springframework.stereotype.Service;

@Service
public class WelcomeService {
    public String retreive() {
        return "Welcome";
    }
}
