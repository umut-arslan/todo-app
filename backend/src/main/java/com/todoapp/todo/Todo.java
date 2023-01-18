package com.todoapp.todo;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.Getter;
@AllArgsConstructor
public class Todo {
    @Getter @Setter
    private Long id;
    @Getter @Setter
    private String title;
    @Getter @Setter
    private boolean completed;

    @Override
    public String toString() {
        return "todo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }
}
