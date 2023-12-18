package com.example.template.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TemplateController {
    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/index2")
    public String index2(){
        return "index2";
    }
}

