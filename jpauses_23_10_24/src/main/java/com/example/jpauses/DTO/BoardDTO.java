package com.example.jpauses.DTO;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder    //Entity->DTO, DTO->Entity변환
public class BoardDTO {
    private int id; //번호

    @NotBlank(message = "제목은 생략이 불가능합니다.")
    @Size(min = 1 ,max = 100, message = "길이는 100글자를 넘을 수 없습니다.")
    private String subject; //제목

    @Size(max = 255, message = "길이는 255자를 넘을 수 없습니다.")
    private String content; //내용

    @NotBlank(message = "작성자는 생략이 불가능합니다")
    private String username; //작성자
    private int viewcnt;    //열람수

    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
}

