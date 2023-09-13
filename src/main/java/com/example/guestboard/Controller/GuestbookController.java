package com.example.guestboard.Controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //컨트롤 클래스로 선언
@Log4j2     //로그처리
@RequiredArgsConstructor    //autowired 대체로 자동주입

public class GuestbookController {
    @GetMapping("/")
    public String index(){
        return "guestbook/modify";
    }
}
