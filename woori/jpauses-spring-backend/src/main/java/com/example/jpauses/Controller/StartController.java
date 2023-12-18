package com.example.jpauses.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartController {

    @GetMapping("/")
    public String index(){
        return "index";
    }
}
//html에 bootstrap 뼈대를 복사해서 붙여넣기 작업
//해더, 푸터, 레이아웃을 디자인
//index.html에 레이아웃을 적용
//board-list.html을 디자인
