package com.example.guestboard.Entity;

import lombok.*;

import javax.persistence.*;

@Entity

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "guest")
public class GuestboardEntity extends BaseEntity{   //공통필드 상속
    @Id //기본키
    @Column(name = "gno")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int gno;    //번호

    @Column(name = "title", length = 100)
    private String title;

    @Column(name = "content", length = 255)
    private String content;

    @Column(name = "writer", length = 20)
    private String writer;
}
