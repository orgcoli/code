package com.example.todo_pr_23_10_27.Controller;

import com.example.todo_pr_23_10_27.DTO.TodoDTO;
import com.example.todo_pr_23_10_27.Entity.TodoEntity;
import com.example.todo_pr_23_10_27.Service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @GetMapping({"/","/todo-list"})
    public String list(@PageableDefault(page = 1)Pageable page, Model model) throws Exception{
        Page<TodoDTO> todoDTOS = todoService.list(page);

        int blockLimit = 5;
        int startPage= (((int)(Math.ceil((double)page.getPageNumber()/blockLimit)))-1) * blockLimit+1;
        int endPage = ((startPage+blockLimit-1)<todoDTOS.getTotalPages())? startPage+blockLimit-1:todoDTOS.getTotalPages();

        model.addAttribute("startPage",startPage);
        model.addAttribute("endPage",endPage);
        model.addAttribute("lists",todoDTOS);

        return "todo/list";
    }

    @GetMapping("/todo-insert")
    public String getInsert() throws Exception{
        return "todo/insert";
    }

    @PostMapping("/todo-insert")
    public String postInsert(TodoDTO todoDTO) throws Exception{
        todoService.insert(todoDTO);
        return "redirect:/todo-list";
    }

    @GetMapping("/todo-update")
    public String getUpdate(int lid, Model model, Integer page) throws Exception{
        TodoDTO todoDTO = todoService.detail(lid);
        model.addAttribute("page",page);
        model.addAttribute("data",todoDTO);
        return "todo/update";
    }

    @PostMapping("/todo-update")
    public String postUpdate(TodoDTO todoDTO) throws Exception{
        todoService.update(todoDTO);
        return "redirect:/todo-list";
    }

    @GetMapping("/todo-delete")
    public String delete(int lid) throws Exception{
        todoService.delete(lid);
        return "redirect:/todo-list";
    }



}
