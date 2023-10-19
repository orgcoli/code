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
@Table(name = "board")

public class BoardEntity extends BaseEntity{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id; //번호    Long

    @Column(name = "subject", length = 100, nullable = false)
    private String subject; //제목

    @Column(name = "content", length = 250)
    private String content; //내용

    @Column(name = "grade")
    private int grade;  //평점

    @Column(name = "username", nullable = false)
    private String username;    //작성자
}
