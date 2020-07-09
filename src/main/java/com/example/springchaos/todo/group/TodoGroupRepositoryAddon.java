package com.example.springchaos.todo.group;

import java.util.List;

public interface TodoGroupRepositoryAddon {
    List<TodoGroup> findTodoGroupsOrderBySize();
}
