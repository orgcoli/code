package com.example.movie_cl_23_11_06.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String main(String errorMessage, Model model)throws Exception{
        model.addAttribute("errorMessage", errorMessage);
        return "index";
    }
}
