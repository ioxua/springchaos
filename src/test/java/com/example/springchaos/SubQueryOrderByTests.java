package com.example.springchaos;

import com.example.springchaos.todo.Todo;
import com.example.springchaos.todo.TodoRepository;
import com.example.springchaos.todo.group.TodoGroup;
import com.example.springchaos.todo.group.TodoGroupRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@RequiredArgsConstructor

@SpringBootTest
class SubQueryOrderByTests {

	@Autowired
	private TodoGroupRepository todoGroupRepository;

	@Autowired
	private TodoRepository todoRepository;

	// I know this is wrong but I have no time to write SQL e.e
	private boolean hasInitialized = false;

	private void createTodosAndGroups() {
		if (hasInitialized) return;

		TodoGroup groupA = new TodoGroup("A");
		TodoGroup groupB = new TodoGroup("B");
		TodoGroup groupC = new TodoGroup("C");

		Todo todoA1 = new Todo("1", groupA);
		Todo todoB1 = new Todo("1", groupB);
		Todo todoB2 = new Todo("2", groupB);
		Todo todoB3 = new Todo("3", groupB);
		Todo todoC1 = new Todo("1", groupC);
		Todo todoC2 = new Todo("2", groupC);

		todoGroupRepository.save(groupA);
		todoGroupRepository.save(groupB);
		todoGroupRepository.save(groupC);

		hasInitialized = true;
	}

	@Test
	void todosAreSaved() {
		createTodosAndGroups();
		assertThat(todoRepository.findAll().size()).isEqualTo(6);
	}

	@Test
	void todoGroupOrderByReturnsOk() {
		createTodosAndGroups();

		List<TodoGroup> orderedGroups = todoGroupRepository.findTodoGroupsOrderBySize();
		assertThat(orderedGroups.get(0).getName()).isEqualTo("B");
		assertThat(orderedGroups.get(1).getName()).isEqualTo("C");
		assertThat(orderedGroups.get(2).getName()).isEqualTo("A");
	}

}
