package com.springboot.webapp.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
    public boolean validateUser(String name, String password) {
        if (name.equalsIgnoreCase("Gagan") && password.equalsIgnoreCase("pass")) {
            return true;
        }
        return false;
    }
}
