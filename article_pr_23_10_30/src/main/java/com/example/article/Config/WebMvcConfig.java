package com.example.article.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//파일업로드 위한 Bean
@Configuration  //사용자가 작성한 클래스, 외부라이브러리를 bean에 등록
public class WebMvcConfig implements WebMvcConfigurer {
    @Value("${uploadPath}")    //application에 선언한 변수값을 읽어올 때
    String uploadPath;

    //Resources 정보를 사용자가 추가
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/images/**")
                .addResourceLocations(uploadPath);
        //registry.addResourceHandler("/css/") //css 추가
        //        .addResourceLocations("file:///c:/css/");
    }
    //resources/static/images..폴더를 file:///c:/image 폴더로 대체
    //addResourceHandler 접근할 주소 /(반드시)접근할폴더명/**(모든것을 사용)
}
