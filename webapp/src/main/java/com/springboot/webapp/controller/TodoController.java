package com.springboot.webapp.controller;

import com.springboot.webapp.model.Todo;
import com.springboot.webapp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;
import java.util.Date;

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
    public String showAddTodo(String desc, ModelMap model) {
        model.addAttribute("todo", new Todo(0, (String)model.get("name"), "", new Date(), false));
        return "todo";
    }

    @RequestMapping(value = "/update-todo", method = RequestMethod.GET)
    public String showUpdateTodo(@RequestParam int id, ModelMap model) {
        Todo todo = todoService.retrieveTodo(id);
        model.put("todo", todo);
        return "todo";
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.POST)
    public String addTodo(ModelMap model, @Valid Todo todo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "todo";
        }
        String user = (String) model.get("name");
        todoService.addTodo(user, todo.getDesc(), new Date(), false);
        return "redirect:/list-todos";
    }

    @RequestMapping(value = "/update-todo", method = RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "todo";
        }
        String user = (String) model.get("name");
        todo.setUser(user);
        todoService.updateTodo(todo);
        return "redirect:/list-todos";
    }

    @RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
    public String deleteTodo(@RequestParam int id) {
        todoService.removeTodo(id);
        return "redirect:/list-todos";
    }
}
