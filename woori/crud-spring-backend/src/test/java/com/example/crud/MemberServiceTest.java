package com.example.crud;

import com.example.crud.DTO.MemberDTO;
import com.example.crud.Service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MemberServiceTest {
    @Autowired
    MemberService memberService;

    //API설계 나 Service설계, Repository설계를 참고해서 이름지정
    @Test   //API설계에서 처리부분에 해당하는 개수만큼, 조회
    public void listForm() throws Exception{     //목록테스트
        List<MemberDTO> memberDTOList = memberService.findAll();

        System.out.println(memberDTOList.toString());
    }

    @Test
    public void insertProc() throws Exception{   //삽입테스트
        //memberService.insert();
        MemberDTO memberDTO = MemberDTO.builder()
                .username("서비스")
                .userid("userService")
                .userpwd("12345678")
                .useremail("sevice@naver.com")
                .usertel("011-445-1234")
                .build();
        memberService.insert(memberDTO);
    }

    @Test
    public void updateProc() throws Exception{   //수정테스트
        //memberService.update();
        MemberDTO memberDTO = MemberDTO.builder()
                .id(1001)
                .username("서비스")
                .userid("userService")
                .userpwd("1234")
                .useremail("sevice@naver.com")
                .usertel("000-445-1234")
                .build();
        memberService.update(memberDTO);
    }

    @Test
    public void deleteProc() throws Exception{   //삭제테스트
        int id =1010;
        memberService.delete(id);
    }

    @Test
    public void detailForm() throws Exception{   //상세테스트
        int id = 1005;
        MemberDTO memberDTO = memberService.findOne(id);
        System.out.println(memberDTO.toString());
    }
}
