package com.example.customlogin_cl_23_11_03;

import com.example.customlogin_cl_23_11_03.DTO.MemberDTO;
import com.example.customlogin_cl_23_11_03.Service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//더미회원 등록
@SpringBootTest
public class MemberServiceTest {
    @Autowired
    MemberService memberService;


    @Test
    @DisplayName("회원가입 테스트")
    public void saveMemeberTest(){
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setName("홍길동");
        memberDTO.setEmail("test1@gmail.com");
        memberDTO.setAddress("경기도 부천시");
        memberDTO.setPassword("1111");

        memberService.saveMember(memberDTO);
    }
}
