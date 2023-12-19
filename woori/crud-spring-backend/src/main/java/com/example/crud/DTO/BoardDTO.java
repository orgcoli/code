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
public class BoardDTO {
    private int id;
    @NotEmpty(message = "제목은 생략이 불가능합니다.")   //검증처리
    private String subject;     //생략 불가능
    private String content;
    private int grade;
    @NotEmpty(message = "작성자는 생략이 불가능합니다.")
    private String username;    //생략불가능
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;
}
