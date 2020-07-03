package com.example.springchaos.todo;

import com.example.springchaos.domain.DomainImpl;
import lombok.Getter;

import javax.persistence.Basic;
import javax.persistence.Entity;

@Getter

@Entity
public class Todo extends DomainImpl {

    @Basic
    private String details;

}
