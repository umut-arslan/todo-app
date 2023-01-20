package com.todoapp.todo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    public List<Todo> getTodos() {
        return List.of(
                new Todo(1L, "Marc das Backend zeigen", false)
        );
    }
}