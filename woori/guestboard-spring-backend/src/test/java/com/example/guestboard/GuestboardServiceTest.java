package com.example.guestboard;

import com.example.guestboard.DTO.GuestboardDTO;
import com.example.guestboard.Entity.GuestboardEntity;
import com.example.guestboard.Service.GuestboardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

@SpringBootTest
public class GuestboardServiceTest {
    @Autowired
    private GuestboardService guestboardService;

    @Test
    public void registerTest() throws Exception{
        GuestboardDTO guestboardDTO = GuestboardDTO.builder()
                .title("서비스테스트")
                .content("서비스 내용")
                .writer("작성맨이야")
                .build();

        guestboardService.register(guestboardDTO);
    }

    @Test
    public void modifyTest() throws Exception{
        GuestboardDTO guestboardDTO = GuestboardDTO.builder()
                .gno(1)
                .title("서비스수정테스트")
                .content("서비스 수정")
                .writer("수정맨이야")
                .build();

        guestboardService.modify(guestboardDTO);
    }

    @Test
    public void removeTest() throws Exception{
        guestboardService.remove(20);
    }

    @Test
    public void listTest()throws Exception{
        String type = "t";
        int page = 1;
        String keyword = "첫";
        Page<GuestboardDTO> list = guestboardService.list(type,page,keyword);
        System.out.println(list.getTotalPages());
    }
}
