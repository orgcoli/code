package com.example.paging.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //맵핑용 클래스로 선언
@RequiredArgsConstructor
public class MainController {
    @GetMapping("/")    //연결할 맵핑명
    public String start(Model model) throws Exception{
        return "index";
    }
}
