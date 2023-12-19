package com.example.crud.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//레이아웃의 구성을 확인
@Controller
public class ProjectStart {
    @GetMapping("/")
    public String index(){
        return "index";
    }
}
