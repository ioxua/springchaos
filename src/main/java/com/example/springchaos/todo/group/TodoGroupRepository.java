package com.example.springchaos.todo.group;

import com.example.springchaos.generic.GenericRepositoryWithALotOfLogic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoGroupRepository extends JpaRepository<TodoGroup, Long>, GenericRepositoryWithALotOfLogic<TodoGroup>,
        TodoGroupRepositoryAddon {
}
