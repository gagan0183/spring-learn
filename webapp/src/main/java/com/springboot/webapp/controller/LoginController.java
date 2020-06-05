package com.springboot.webapp.controller;

import com.springboot.webapp.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String welcome(@RequestParam("name") String name, @RequestParam("password") String password, ModelMap model) {
        boolean isValidUser = this.loginService.validateUser(name, password);
        if (!isValidUser) {
            model.addAttribute("invalid", "Invalid name");
            return "login";
        }
        model.addAttribute("name", name);
        return "welcome";
    }
}
