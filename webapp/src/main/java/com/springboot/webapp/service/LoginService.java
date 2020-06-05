package com.springboot.webapp.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
    public boolean validateUser(String name, String password) {
        System.out.print("name " + name);
        System.out.print("password " + password);
        if (name.equalsIgnoreCase("test") && password.equalsIgnoreCase("pass")) {
            return true;
        }
        return false;
    }
}
