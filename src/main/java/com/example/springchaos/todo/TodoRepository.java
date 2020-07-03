package com.example.springchaos.todo;

import com.example.springchaos.generic.GenericRepositoryWithALotOfLogic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long>, GenericRepositoryWithALotOfLogic<Todo> {
}
