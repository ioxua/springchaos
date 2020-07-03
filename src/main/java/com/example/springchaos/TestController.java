package com.example.springchaos;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springchaos.thisworks.ThisWorks;
import com.example.springchaos.thisworks.ThisWorksRepository;
import com.example.springchaos.todo.Todo;
import com.example.springchaos.todo.TodoRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

@RestController
public class TestController {

	private final TodoRepository todoRepository;
	private final ThisWorksRepository thisWorksRepository;

	@GetMapping("/thisWorks")
	public List<?> thisWorks() {
		return thisWorksRepository.doStuff(ThisWorks.class);
	}

	@GetMapping("/thisDoesnt")
	public List<?> thisDoesnt() {
		return todoRepository.doStuff(Todo.class);
	}

}
