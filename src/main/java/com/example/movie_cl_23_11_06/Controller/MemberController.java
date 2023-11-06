package com.example.movie_cl_23_11_06.Controller;

import com.example.movie_cl_23_11_06.DTO.MemberDTO;
import com.example.movie_cl_23_11_06.Service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/member/login")
    public String loginForm(Model model) throws Exception{
        return "/member/login";
    }

    @GetMapping("/member/login/error")
    public String loginError(Model model)throws Exception{
        model.addAttribute("loginErrorMsg", "아이디또는 비밀번호를 확인해 주세요");
        return "/member/login";
    }

    @GetMapping("/member/register")
    public String registerForm(Model model) throws Exception{
        MemberDTO memberDTO = new MemberDTO();
        model.addAttribute("memberDTO", memberDTO);
        return "/member/register";
    }

    @PostMapping("/member/register")
    public String registerProc(@Valid MemberDTO memberDTO,
                               BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model)throws Exception{
        if(bindingResult.hasErrors()){
            return "/member/register";
        }
        try {
            memberService.saveMember(memberDTO);
            redirectAttributes.addAttribute
        }
    }
}
