package com.springboot.webapp.service;

import com.springboot.webapp.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();
    private static int todoCount = 3;

    static {
        todos.add(new Todo(1, "Gagan", "React", new Date(), false));
        todos.add(new Todo(2, "Gagan", "Angular", new Date(), false));
        todos.add(new Todo(3, "Gagan", "Cassandra", new Date(), false));
    }

    public List<Todo> retrieveTodos(String user) {
        List<Todo> filteredTodos = new ArrayList<>();
        for (Todo todo: todos) {
            if (todo.getUser().equals(user)) {
                filteredTodos.add(todo);
            }
        }
        return filteredTodos;
    }

    public void addTodo(String user, String desc, Date date, boolean isDone) {
        todos.add(new Todo(++todoCount, user, desc, date, isDone));
    }

    public Todo retrieveTodo(int id) {
        for (Todo todo: todos) {
            if(todo.getId() == id) {
                return todo;
            }
        }
        return null;
    }

    public void updateTodo(Todo todo) {
        todos.remove(todo);
        todos.add(todo);
    }

    public void removeTodo(int id) {
        Iterator<Todo> todoIterator = todos.iterator();
        while(todoIterator.hasNext()) {
            Todo todo = todoIterator.next();
            if (todo.getId() == id) {
                todoIterator.remove();
            }
        }
    }
}
