package com.example.bookpr_231020.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class BookController {

    @GetMapping("/")
    public String index() throws Exception{
        return "index";
    }

    @GetMapping("/book-list")
    public String bookList() throws Exception{
        return "book/list";
    }

    @GetMapping("/book-insert")
    public String getBookInsert() throws Exception{
        return "book/insert";
    }

    @PostMapping("/book-insert")
    public String postBookInsert() throws Exception{
        return "redirect:/";
    }

    @GetMapping("/book-update")
    public String getBookUpdate() throws Exception{
        return "book/update";
    }

    @PostMapping("/book-update")
    public String postBookUpdate() throws Exception{
        return "redirect:/book-list";
    }

    @GetMapping("/book-delete")
    public String bookDelete() throws Exception{
        return "redirect:/book-list";
    }
    @GetMapping("/book-detail")
    public String bookDetail() throws Exception{
        return "book/detail";
    }
}
