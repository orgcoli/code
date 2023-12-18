package com.example.todo_pr_23_10_27.Entity;

import lombok.*;

import javax.persistence.*;

@Entity

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "todo_tbl")

public class TodoEntity extends BaseEntity {
    @Id
    @Column(name = "lid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lid;

    @Column(name = "ltitle" , nullable = false, length = 100)
    private String ltitle;

    @Column(name = "lcontent", length = 200)
    private String lcontent;

    @Column(name = "limpt")
    private int limpt;

    @Column(name = "fterm", length = 30)
    private String fterm;

    @Column(name = "lterm", length = 30)
    private String lterm;
}
