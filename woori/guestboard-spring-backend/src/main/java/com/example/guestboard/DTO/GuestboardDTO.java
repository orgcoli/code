package com.example.guestboard.DTO;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter //해당 메소드 자동 생성
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class GuestboardDTO {
    private int gno;    //번호
    @NotBlank(message = "제목은 생략이 불가능합니다.")
    private String title;
    private String content;
    @NotBlank(message = "작성자는 생략이 불가능합니다.")
    private String writer;
    private LocalDateTime regDate;  //생성날짜
    private LocalDateTime modDate;  //수정날짜
}
