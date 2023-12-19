package com.example.crud.DTO;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberDTO {
    private int id;             //회원번호

    @NotEmpty(message = "이름은 생략이 불가능합니다.")
    private String username;    //회원이름

    @NotEmpty(message = "아이디는 생략이 불가능합니다.")
    private String userid;      //아이디

    @NotEmpty(message = "비밀번호는 생략이 불가능합니다.")
    private String userpwd;     //비밀번호

    @NotEmpty(message = "이메일은 생략이 불가능합니다.")
    private String useremail;   //이메일

    private String usertel;     //전화번호

    private LocalDateTime createDate;
    private LocalDateTime modifyDate;


}
//실행해서 데이터베이스서버에 테이블 생성을 확인