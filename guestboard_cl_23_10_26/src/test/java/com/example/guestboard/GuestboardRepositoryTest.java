package com.example.guestboard;

import com.example.guestboard.Entity.GuestboardEntity;
import com.example.guestboard.Repository.GuestboardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
public class GuestboardRepositoryTest {
    @Autowired
    private GuestboardRepository guestboardRepository;

    @Test
    public  void  guestInsert() {
        for (int i = 1; i <= 50; i++) {
            GuestboardEntity guestboardEntity = GuestboardEntity.builder()
                    .title("첫 데이터"+(i%5))
                    .content("첫 내용" +i)
                    .writer("홍길동" +i)
                    .build();
            guestboardRepository.save(guestboardEntity);
        }
    }

    @Test
    public void paging(){ //findAll로 먼저 테스트
        Page<GuestboardEntity> guestboardEntities = guestboardRepository
                .findAll(PageRequest.of(1,20, Sort.by(Sort.Direction.DESC, "gno")));
        //List<GuestboardEntity> guestboardEntities = guestboardRepository.findAll();
        System.out.println(guestboardEntities.getTotalPages());
    }

    @Test
    public void searchTitleTest(){
        Page<GuestboardEntity> guestboardEntities = guestboardRepository
                .searchTitle("첫", PageRequest.of(1,10, Sort.by(Sort.Direction.DESC, "gno")));
        System.out.println("총페이지 수 : " + guestboardEntities.getTotalPages());
    }

    @Test
    public void searchContentTest(){
        Page<GuestboardEntity> guestboardEntities = guestboardRepository
                .searchContent("첫", PageRequest.of(1,10, Sort.by(Sort.Direction.DESC, "gno")));
        System.out.println("총페이지 수 : " + guestboardEntities.getTotalPages());
    }

    @Test
    public void searchWriterTest(){
        Page<GuestboardEntity> guestboardEntities = guestboardRepository
                .searchWriter("첫", PageRequest.of(1,10, Sort.by(Sort.Direction.DESC, "gno")));
        System.out.println("총페이지 수 : " + guestboardEntities.getTotalPages());
    }

    @Test
    public void searchTitleContentTest(){
        Page<GuestboardEntity> guestboardEntities = guestboardRepository
                .searchTitleContent("첫", PageRequest.of(1,10, Sort.by(Sort.Direction.DESC, "gno")));
        System.out.println("총페이지 수 : " + guestboardEntities.getTotalPages());
    }

    @Test
    public void searchTitleContentWriterTest(){
        Page<GuestboardEntity> guestboardEntities = guestboardRepository
                .searchTitleContentWriter("첫", PageRequest.of(1,10, Sort.by(Sort.Direction.DESC, "gno")));
        System.out.println("총페이지 수 : " + guestboardEntities.getTotalPages());
    }
}
