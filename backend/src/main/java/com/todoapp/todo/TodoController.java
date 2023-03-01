package com.todoapp.todo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "api/v1/todos")
@AllArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @GetMapping()
    public List<Todo> getTodos() {
        return todoService.getTodos();
    }

}
