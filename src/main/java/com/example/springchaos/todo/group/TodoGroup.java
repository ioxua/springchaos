package com.example.springchaos.todo.group;

import com.example.springchaos.domain.DomainImpl;
import com.example.springchaos.todo.Todo;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Getter
@NoArgsConstructor

@Entity
public class TodoGroup extends DomainImpl {

    @Basic
    private String name;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private Set<Todo> todos;

    public TodoGroup(String name) {
        this.name = name;
    }

    public TodoGroup addTodo(Todo todo) {
        if (null == this.todos) this.todos = new HashSet<>();
        this.todos.add(todo);
        return this;
    }

}
