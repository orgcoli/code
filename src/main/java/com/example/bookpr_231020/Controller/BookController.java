package com.example.bookpr_231020.Controller;

import com.example.bookpr_231020.DTO.BookDTO;
import com.example.bookpr_231020.Service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping("/")
    public String index() throws Exception{
        return "index";
    }

    @GetMapping("/book-list")
    public String bookList(Model model) throws Exception{
        List<BookDTO> lists = bookService.selectAll();

        model.addAttribute("lists", lists);
        return "book/list";
    }

    @GetMapping("/book-insert")
    public String getBookInsert(Model model) throws Exception{
        BookDTO bookDTO = new BookDTO();
        model.addAttribute("bookDTO", bookDTO);
        return "book/insert";
    }

    @PostMapping("/book-insert")
    public String postBookInsert(@Valid BookDTO bookDTO, BindingResult bindingResult) throws Exception{
        if(bindingResult.hasErrors()){
            return "book/insert";
        }
        bookService.insert(bookDTO);
        return "redirect:/";
    }

    @GetMapping("/book-update")
    public String getBookUpdate(Long bid, Model model) throws Exception{
        BookDTO bookDTO = bookService.selectOne(bid);
        model.addAttribute("bookDTO", bookDTO);
        return "book/update";
    }

    @PostMapping("/book-update")
    public String postBookUpdate(@Valid BookDTO bookDTO, BindingResult bindingResult) throws Exception{
        if(bindingResult.hasErrors()){
            return "book/update";
        }
        bookService.update(bookDTO);
        return "redirect:/book-list";
    }

    @GetMapping("/book-delete")
    public String bookDelete(Long bid) throws Exception{
        bookService.delete(bid);
        return "redirect:/book-list";
    }
    @GetMapping("/book-detail")
    public String bookDetail(Long bid, Model model) throws Exception{
        BookDTO list = bookService.selectOne(bid);
        model.addAttribute("list", list);
        return "book/detail";
    }
}
