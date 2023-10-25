package com.example.paging;

import com.example.paging.DTO.PagingDTO;
import com.example.paging.Service.PagingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PagingServiceTest {
    @Autowired
    PagingService pagingService;

    @Test
    public void search()throws Exception{
        String subject="연습용";
        List<PagingDTO>result = pagingService.search(subject);
        System.out.println(result.toString());
    }
}
