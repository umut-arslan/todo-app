package com.todoapp.todo;

import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    @Getter
    private List<Todo> todos = List.of(
            new Todo(1L, "Marc das Backend zeigen", false)
    );
}