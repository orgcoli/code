package com.example.bookpr_231020;

import com.example.bookpr_231020.DTO.BookDTO;
import com.example.bookpr_231020.Service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BookServiceTest {
    @Autowired
    BookService bookService;

    @Test
    public void insert() throws Exception{
        BookDTO bookDTO = BookDTO.builder()
                .bcode(1)
                .bsub("제목")
                .binfo("정보")
                .bwriter("저자")
                .bcom("출판사")
                .brel("발매일")
                .bprice(30000)
                .build();
       bookService.insert(bookDTO);
    }

    @Test
    public void selectAll() throws Exception{
        List<BookDTO> data = bookService.selectAll();

        System.out.println(data.toString());
    }

    @Test
    public void update() throws Exception {
        BookDTO bookDTO = BookDTO.builder()
                .bid(2L)
                .bcode(1)
                .bsub("제목")
                .binfo("정보")
                .bwriter("저자")
                .bcom("출판사")
                .brel("발매일")
                .bprice(30000)
                .build();
        bookService.update(bookDTO);
    }

    @Test
    public void delete() throws Exception{
        Long id = 10L;
        bookService.delete(id);
    }

    @Test
    public void detail() throws Exception{
        Long id = 8L;
        BookDTO bookDTO = bookService.selectOne(id);
        System.out.println(bookDTO.toString());
    }
}
