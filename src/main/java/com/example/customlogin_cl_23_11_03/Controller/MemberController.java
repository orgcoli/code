package com.example.customlogin_cl_23_11_03.Controller;

import com.example.customlogin_cl_23_11_03.DTO.MemberDTO;
import com.example.customlogin_cl_23_11_03.Service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    private final PasswordEncoder passwordEncoder;
    //로그인 폼으로 이동
    //로그인 처리는 SecurityConfig 에서 자동처리되므로 Controller에서는 생략
    @GetMapping("/member/login")
    public String loginForm(Model model) throws Exception{
        return "member/login";
    }
    //로그인시 오류발생 처리
    @GetMapping("/member/login/error")
    public String loginError(Model model) throws Exception{
        model.addAttribute("loginErrorMsg" , "아이디 또는 비밀번호를 확인해 주세요");
        return "/member/login";
    }

    @GetMapping("/member/register") //회원가입 폼
    public String registerForm(Model model) throws Exception{
        MemberDTO memberDTO = new MemberDTO();
        model.addAttribute("memberDTO",memberDTO);
        return "member/register";
    }

    @PostMapping("/member/register") //회원가입 폼
    public String registerproc(@Valid MemberDTO memberDTO,
                               RedirectAttributes redirectAttributes, BindingResult bindingResult, Model model) throws Exception{

        if (bindingResult.hasErrors()){
            return "/member/register";
        }
        try {
            memberService.saveMember(memberDTO);    //신규회원 등록 처리
            redirectAttributes.addAttribute("errorMessage", "가입을 성공하였습니다.");
        }catch (IllegalStateException e){
            model.addAttribute("errorMessage",e.getMessage());  //서비스에 저장된 오류메세지
            return "/member/register";
        }
        return "redirect:/";
    }

    @GetMapping("/admin/list")
    public String admin(Model model) throws Exception{
        return "/admin/list";
    }

    @GetMapping("/user/list")
    public String user(Model model)throws Exception{
        return "/user/list";
    }
}
