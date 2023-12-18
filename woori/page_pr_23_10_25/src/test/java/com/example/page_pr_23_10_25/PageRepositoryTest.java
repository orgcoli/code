/*======================================================================================================
 * 프로그램명    : PageRepositoryTest
 * 설명 : PageRepository를 이용하여 테스트
 *       어노테이션
 *       @SpringBootTest, @Autowired
 *       리스트를 확인하기 위해서 save 처리
 *       PageRepository 에서 save를 사용하여 데이터 저장
 *       for 문을 사용해서 반복해서 0~49번 데이터 저장
 * 작성자 : 이민호
 * 작성일 : 2023-10-25
 * 수정사항 : ----
 ======================================================================================================*/


package com.example.page_pr_23_10_25;

import com.example.page_pr_23_10_25.Entity.PageEntity;
import com.example.page_pr_23_10_25.Repository.PageRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PageRepositoryTest {
    @Autowired
    PageRepository pageRepository;

    @Test
    public void insert() throws Exception{
        for(int i=0;i<50;i++) {
            PageEntity pageEntity = PageEntity.builder()
                    .subject("연습제목"+i)
                    .content("연습내용"+i)
                    .username("연습맨"+i)
                    .build();
            pageRepository.save(pageEntity);
        }
    }
}
