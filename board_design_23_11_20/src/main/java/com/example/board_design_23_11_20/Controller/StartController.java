package com.example.board_design_23_11_20.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartController {

    @GetMapping("/")
    public String main()throws Exception{
        return "index";
    }
}
