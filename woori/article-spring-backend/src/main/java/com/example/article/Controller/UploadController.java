package com.example.article.Controller;

import com.example.article.Service.UploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequiredArgsConstructor
public class UploadController {
    private final UploadService uploadService;
    @GetMapping("/upload/upload")
    public String uploadForm(Model model) throws Exception{  //입력폼 이동
        return "upload/upload";
    }

    @PostMapping("/upload/upload")
    public String uploadProc(String title, MultipartFile file,
                             Model model)throws Exception{
        System.out.println("받은 파일명 : " +file.getOriginalFilename());
        String newFileName = uploadService.saveImg(file);
        System.out.println("저장시 사용한 파일명" + newFileName);
        //newFileName은 새로운 파일명만 존재
        //폴더명 +파일명
        // /images/item/aa.jpg ===> c:/image/item/aa.jpg
        model.addAttribute("img","/images/item/"+newFileName);
        model.addAttribute("imgfile",newFileName);

        return "upload/list";
    }
}
