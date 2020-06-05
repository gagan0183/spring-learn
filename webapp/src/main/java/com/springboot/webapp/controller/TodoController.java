package com.springboot.webapp.controller;

import com.springboot.webapp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @RequestMapping(value = "/list-todos", method = RequestMethod.GET)
    public String todosList(ModelMap model) {
        String user = (String) model.get("name");
        model.addAttribute("todos", todoService.retrieveTodos(user));
        return "list-todos";
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.GET)
    public String addTodo() {
        return "add-todo";
    }
}
