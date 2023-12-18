package com.example.customlogin_cl_23_11_03.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartController {
    @GetMapping({"/","/index","/main","/start"})
    public String start() throws Exception{
        return "index";
    }
}
