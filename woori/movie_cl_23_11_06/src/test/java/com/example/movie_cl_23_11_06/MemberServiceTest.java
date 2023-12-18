package com.example.movie_cl_23_11_06;

import com.example.movie_cl_23_11_06.DTO.MemberDTO;
import com.example.movie_cl_23_11_06.Service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberServiceTest {
    @Autowired
    MemberService memberService;

    @Test
    public void saveMember(){
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setName("동동이");
        memberDTO.setEmail("test3@gmail.com");
        memberDTO.setPassword("1111");

        memberService.saveMember(memberDTO);
    }
}
