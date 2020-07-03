package com.example.springchaos;

import com.example.springchaos.thisworks.ThisWorksRepository;
import com.example.springchaos.todo.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor

@RestController
public class TestController {

    private final TodoRepository todoRepository;
    private final ThisWorksRepository thisWorksRepository;

    @GetMapping("/thisWorks")
    public List<?> thisWorks() {
        return thisWorksRepository.doStuff();
    }

    @GetMapping("/thisDoesnt")
    public List<?> thisDoesnt() {
        return todoRepository.doStuff();
    }

}
