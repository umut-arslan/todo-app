package com.todoapp.todo;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Todo {
    @Getter @Setter
    private Long id;
    @Getter @Setter
    private String title;
    @Getter @Setter
    private boolean completed;
}
