package com.example.springchaos.todo;

import com.example.springchaos.domain.DomainImpl;
import com.example.springchaos.todo.group.TodoGroup;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Getter
@NoArgsConstructor

@Entity
public class Todo extends DomainImpl {

    @Basic
    private String details;

    @ManyToOne(fetch = FetchType.LAZY)
    private TodoGroup group;

    public Todo(String details, TodoGroup group) {
        this.details = details;
        this.group = group;
        group.addTodo(this);
    }

}
