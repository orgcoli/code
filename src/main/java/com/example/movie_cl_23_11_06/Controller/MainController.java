package com.example.movie_cl_23_11_06.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String main()throws Exception{
        return "index";
    }
}
