package com.example.paging;

import com.example.paging.Entity.PagingEntity;
import com.example.paging.Repository.PagingRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PagingRepositoryTest {
    @Autowired
    PagingRepository pagingRepository;

    @Test
    public void insert() throws Exception{
        for(int i=0;i<50;i++) {
            PagingEntity pagingEntity = PagingEntity.builder()
                    .subject("실습용 테스트" + i)
                    .content("실습용" + i)
                    .username("실습이" + i)
                    .viewcnt(i)
                    .build();
            pagingRepository.save(pagingEntity);
        }
    }

    @Test
    public void SearchTest() throws Exception{
        //변수 = 메소드()...표현식
        //작업순서는 메소드() 사용법확인 변수=
        //메소드에서 ()안에 내용은 위쪽 프로그램에서 참고
        //변수 = 는 아래쪽에서 사용하기 위한 준비
        String subject="연습용";
        List<PagingEntity> result = pagingRepository.findSearch(subject);
        System.out.println(result.toString());
    }
}
