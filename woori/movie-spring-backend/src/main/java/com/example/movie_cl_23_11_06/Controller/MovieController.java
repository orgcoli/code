package com.example.movie_cl_23_11_06.Controller;

import com.example.movie_cl_23_11_06.DTO.MovieDTO;
import com.example.movie_cl_23_11_06.Service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor

public class MovieController {
    private final MovieService movieService;

    @GetMapping("/movie/list")
    public String movieList(Model model) throws Exception{
        List<MovieDTO> movieDTOS = movieService.list();

        model.addAttribute("movieDTOS",movieDTOS);

        return "/movie/list";
    }

    @GetMapping("/movie/detail")
    public String movieDetail(Integer id, Model model) throws Exception{
        MovieDTO movieDTO = movieService.detail(id);

        model.addAttribute("movieDTO",movieDTO);

        return "/movie/detail";
    }

    @GetMapping("/admin/list")
    public String adminList(Model model) throws Exception{
        List<MovieDTO> lists = movieService.list();

        model.addAttribute("lists",lists);

        return "/admin/list";
    }

    @GetMapping("/admin/register")
    public String adminRegisterForm(Model model) throws Exception{
        MovieDTO movieDTO = new MovieDTO();

        model.addAttribute("movieDTO",movieDTO);

        return "/admin/register";
    }

    @PostMapping("/admin/register")
    public String adminRegisterProc(@Valid MovieDTO movieDTO, BindingResult bindingResult,
                                    MultipartFile imgFile) throws Exception{
        if(bindingResult.hasErrors()){
            return "/admin/register";
        }
        movieService.insert(movieDTO,imgFile);
        return "redirect:/admin/list";
    }

    @GetMapping("/admin/detail")
    public String adminDetail(Integer id, Model model) throws Exception{
        MovieDTO list = movieService.detail(id);

        model.addAttribute("list",list);

        return "/admin/detail";
    }

    @GetMapping("/admin/update")
    public String adminUpdateForm(Integer id, Model model) throws Exception{
        MovieDTO movieDTO = movieService.detail(id);

        model.addAttribute("movieDTO", movieDTO);

        return "/admin/update";
    }

    @PostMapping("/admin/update")
    public String adminUpdateProc(@Valid MovieDTO movieDTO, BindingResult bindingResult,
                                  MultipartFile imgFile) throws Exception{
        if(bindingResult.hasErrors()){
            return "/admin/update";
        }
        movieService.insert(movieDTO, imgFile);
        return "redirect:/admin/list";
    }

    @GetMapping("/admin/remove")
    public String adminRemove(Integer id) throws Exception{
        movieService.delete(id);
        return "redirect:/movie/list";

    }
}
