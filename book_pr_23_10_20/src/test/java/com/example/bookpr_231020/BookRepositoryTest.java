package com.example.bookpr_231020;

import com.example.bookpr_231020.Entity.BookEntity;
import com.example.bookpr_231020.Repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class BookRepositoryTest {
    @Autowired
    BookRepository bookRepository;

    @Test
    public void insert(){
        for(int i =0; i<50; i++) {
            BookEntity bookEntity = BookEntity.builder()
                    .bcode(2)
                    .bsub("책이름"+i)
                    .binfo("책정보"+i)
                    .bwriter("작성자"+i)
                    .bcom("출판사"+i)
                    .brel("2023-10-15")
                    .bprice(15000)
                    .build();
            bookRepository.save(bookEntity);
        }
    }

    @Test
    public void update(){
        Long bid = 2L;

        Optional<BookEntity> find = bookRepository.findById(bid);
        BookEntity data = find.orElseThrow();

        data.setBinfo("수정내용");
        data.setBsub("수정제목");

        BookEntity result = bookRepository.save(data);
    }

    @Test
    public void delete(){
        Long bid = 10L;

        bookRepository.deleteById(bid);
    }

    @Test
    public void findAll(){
        List<BookEntity> list = bookRepository.findAll();

        for(BookEntity data: list){
            System.out.println(data.toString());
        }
    }

    @Test
    public void findOne(){
        Long bid = 13L;
        Optional<BookEntity> data = bookRepository.findById(bid);

        System.out.println(data.toString());
    }
}
