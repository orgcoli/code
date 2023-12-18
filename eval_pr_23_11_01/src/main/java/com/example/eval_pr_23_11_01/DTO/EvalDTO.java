package com.example.eval_pr_23_11_01.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class EvalDTO {
    private int id;
    private String userid;
    private String lname;
    private String pname;
    private int lyear;
    private String sdivide;
    private String ldivide;
    private String etitle;
    private String econtent;
    private String tscore;
    private String gscore;
    private String cscore;
    private String lscore;
    private int lcount;
}
