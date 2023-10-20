package com.example.crud.Controller;

import com.example.crud.DTO.MemberDTO;
import com.example.crud.Service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

//1. 페이지연결(API 설계를 참고)
//2. Service 연결(Service 테스트 후)
@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/memberlist")  //회원목록
    public String listForm(Model model) throws  Exception{  //선언메소드
        List<MemberDTO> lists = memberService.findAll();    //서비스
        //전달변수 복사
        model.addAttribute("lists",lists);      //전달값을 저장
        return "member/list";
        //이동페이지
    }

    @GetMapping("/memberinsert")    //회원가입폼
    public String insertForm(Model model) throws Exception{
        //빈DTO 전달해서 오류를방지
        MemberDTO memberDTO = new MemberDTO();
        model.addAttribute("memberDTO", memberDTO);
        return "member/insert";
    }

    @PostMapping("/memberinsert")   //회원가입처리
    public String insertProc(@Valid MemberDTO memberDTO, BindingResult bindingResult, Model model)throws Exception{
        if(bindingResult.hasErrors()){
            return "member/insert";
        }
        memberService.insert(memberDTO);
        return "redirect:/";    //메인이동
    }

    @GetMapping("/memberupdate")    //회원수정폼
    public String updateForm(int id, Model model) throws Exception{
        MemberDTO memberDTO = memberService.findOne(id);    //서비스

        model.addAttribute("memberDTO",memberDTO);
        return "member/update";
    }

    @PostMapping("memberupdate")    //회원수정처리
    public String updateProc(@Valid MemberDTO memberDTO, BindingResult bindingResult, Model model) throws Exception{
        //@Valid 오류발생===>BindingResult 오류처리
        //오류발생시 처리할 부분
        if(bindingResult.hasErrors()){
            return "member/update";
        }
        memberService.update(memberDTO);
        return "redirect:/memberlist";
    }

    @GetMapping("/memberdelete")    //회원삭제처리
    public String deleteProc(int id, Model model) throws Exception{
        memberService.delete(id);   //서비스
        return "redirect:/memberlist";
    }

    @GetMapping("/memberdetail")    //회원상세정보
    public String detailForm(int id, Model model) throws Exception{
        MemberDTO memberDTO = memberService.findOne(id);
        model.addAttribute("memberDTO", memberDTO); //보낼값

        return "member/detail";
    }
}
//html에 변수들을 연결하시고, 나중에 검증 및 추가기능을 꾸미기
