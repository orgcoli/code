package com.example.customlogin_cl_23_11_03.Config;

import com.example.customlogin_cl_23_11_03.Service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@Log4j2
@EnableWebSecurity
@RequiredArgsConstructor
//extends WebSecurityConfigurerAdapter 이전버전에서 사용하는 방식 (2.7.0이후에는 사용불가)
public class SecurityConfig {
    //로그인 처리하는 Service를 연동
    MemberService memberService;

    //1. 암호의 암호화
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //2. 커스텀 로그인 설정(버전에 따라 사용하는 방법이 다르다.)
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        //맵핑에 따른 접근권한 부여
        //antMatchers(맵핑명, ...).권한 : 정확히 일치하는 맵핑, antMatchers("/test") -> /test만 일치
        //mvcMatchers(맵핑명, ...).권한 : 비슷하게 일치하는 맵핑 mvcMatcher("/test") - >/test, /test.html ... test만 포함되면
        //권한 : permitAll()- 권한없음(로그인 없이 사용가능), hasRole("권한명") - 해당권한만 부여
        http.authorizeHttpRequests(auth->{
            auth.antMatchers("/","/member/login", "/member/register").permitAll(); //나열
            auth.antMatchers("/user/list","/member/logout").hasAnyRole("USER","ADMIN");
            auth.antMatchers("/admin/list").hasAnyRole("ADMIN");

        });
        //로그인처리에 대한 설정
        //loginPage(로그인 화면으로 사용할 페이지), defaultSuccessURL(로그인 성공시 이동할 페이지)
        //failureURL(로그인 실패시 이동할 페이지), usernameParameter(username으로 사용할 변수)
        http.formLogin()
                .loginPage("/member/login")
                .defaultSuccessUrl("/")
                .usernameParameter("email")
                .failureUrl("/member/login/error");
        http.csrf().disable();   //페이지 변조방지를 사용안함
        //로그아웃에 대한 설정
        //logoutRequestMatcher(로그아웃 후 처리할 위치)
        //logoutSuccessUrl(로그아웃시 이동할 페이지
        http.logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))
                .logoutSuccessUrl("/");
        return http.build();
    }
}
