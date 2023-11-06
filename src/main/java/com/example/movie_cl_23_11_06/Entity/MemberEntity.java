package com.example.movie_cl_23_11_06.Entity;

import com.example.movie_cl_23_11_06.Constant.Role;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "member")
@SequenceGenerator(
        name = "member_SEQ",
        sequenceName = "member_SEQ",
        initialValue = 1,
        allocationSize = 1)
public class MemberEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "member_SEQ")
    private Integer id;

    @Column(length = 100)
    private String name;

    @Column(length = 100, unique = true)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;
}
