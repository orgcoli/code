package com.example.customlogin_cl_23_11_03.Entity;

import com.example.customlogin_cl_23_11_03.Constant.Role;
import lombok.*;

import javax.persistence.*;

//회원 테이블(로그인 테이블은 자동생성자 사용X)
//DTO, Entity는 Service에서 사용할 때 오류
//builder는 생성자가 있을때만 사용 가능
@Entity
@Getter
@Setter
@ToString
@Table(name = "custommember")
public class MemberEntity {
    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;      //번호

    private String name;    //회원명

    @Column(unique = true)
    private String email;   //이메일 (로그인시 사용할 id)

    private String password;

    private String address; //주소

    @Enumerated(EnumType.STRING)
    private Role role;
}
