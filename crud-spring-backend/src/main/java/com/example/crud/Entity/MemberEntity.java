package com.example.crud.Entity;

import lombok.*;

import javax.persistence.*;

@Entity

@Getter
@Setter
@ToString

@AllArgsConstructor
@NoArgsConstructor
@Builder
//개발자가 테이블을 생성해서 운영하고 싶으면 Application에 DDL을 none설정하고
//수동으로 테이블을 생성
@Table(name = "member")
public class MemberEntity extends BaseEntity{
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;             //회원번호

    @Column(name="username" , length = 20, nullable = false)
    private String username;    //회원이름

    @Column(name="userid" , length = 20, nullable = false)
    private String userid;      //아이디

    @Column(name="userpwd" , length = 50, nullable = false)
    private String userpwd;     //비밀번호

    @Column(name="useremail" , length = 20, nullable = false)
    private String useremail;   //이메일

    @Column(name="usertel", length = 20)
    private String usertel;     //전화번호
}
//1. 변수선언해서 DTO 복사
//2. 필드와 연동처리
//3. nullable이 선언된 변수를 DTO에서 유효성 처리