package com.example.todo_pr_23_10_27.DTO;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class TodoDTO {
    private int lid;
    @NotBlank(message = "제목은 생략이 불가능합니다.")
    private String ltitle;
    private String lcontent;
    private int limpt;
    private String fterm;
    private String lterm;
}
