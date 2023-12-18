package com.example.article;

import com.example.article.Entity.DiscussionEntity;
import com.example.article.Repository.DiscussionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DiscussionRepositoryTest {
    @Autowired
    private DiscussionRepository discussionRepository;

    //토론주제 등록, 삽입, 수정, 삭제 등 기본 기능은 단위테스트 불필요
    @Test
    public void register() throws Exception{
        for(int i=1; i<=50; i++) {
            DiscussionEntity data = DiscussionEntity.builder()
                    .subject("테스트 진행"+i)
                    .build();

            discussionRepository.save(data);
        }
    }

    @Test
    public void viewcntTest() throws Exception{

        discussionRepository.viewcnt(1);
    }
}
