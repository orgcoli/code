package com.example.todo_pr_23_10_27;

import com.example.todo_pr_23_10_27.DTO.TodoDTO;
import com.example.todo_pr_23_10_27.Service.TodoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TodoServiceTest {
    @Autowired
    TodoService todoService;

    @Test
    public void serviceInsert() throws Exception{
        TodoDTO todoDTO = TodoDTO.builder()
                .ltitle("서비스 제목")
                .lcontent("서비스 내용")
                .limpt(2)
                .fterm("2023-10-12")
                .lterm("2023-10-16")
                .build();
        todoService.insert(todoDTO);
    }

    @Test
    public void serviceUpdate() throws Exception{
        TodoDTO todoDTO = TodoDTO.builder()
                .lid(2)
                .ltitle("서비스 제목")
                .lcontent("서비스 내용")
                .limpt(2)
                .fterm("2023-10-12")
                .lterm("2023-10-16")
                .build();
        todoService.update(todoDTO);
    }
}
