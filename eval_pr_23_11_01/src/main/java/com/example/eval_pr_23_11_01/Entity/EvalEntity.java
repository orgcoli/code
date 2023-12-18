package com.example.eval_pr_23_11_01.Entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@DynamicInsert
@DynamicUpdate
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

@Table(name = "eval_tbl")
@SequenceGenerator(name = "eval_SEQ",
        sequenceName = "eval_SEQ",
        initialValue = 1,
        allocationSize = 1)
public class EvalEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "eval_SEQ")
    private int id;

    @Column(name = "userid", length = 50)
    private String userid;

    @Column(name = "lname", length = 50, nullable = false)
    private String lname;

    @Column(name = "pname", length = 50, nullable = false)
    private String pname;

    @Column(name = "lyear")
    private int lyear;

    @Column(name = "sdivide", length = 20)
    private String sdivide;

    @Column(name = "ldivide", length = 10)
    private String ldivide;

    @Column(name = "etitle", length = 50, nullable = false)
    private String etitle;

    @Column(name = "econtent", length = 2048)
    private String econtent;

    @Column(name = "tscore", length = 10)
    private String tscore;

    @Column(name = "gscore", length = 10)
    private String gscore;

    @Column(name = "cscore", length = 10)
    private String cscore;

    @Column(name = "lscore", length = 10)
    private String lscore;

    @Column(name = "lcount")
    @ColumnDefault("0")
    private int lcount;
}
