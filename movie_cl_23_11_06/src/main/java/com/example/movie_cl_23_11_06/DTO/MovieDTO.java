package com.example.movie_cl_23_11_06.DTO;

import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class MovieDTO {
    private Integer id;

    @NotEmpty(message = "제목은 생략할 수 없습니다.")
    private String movie;

    private String content;

    private String img;

    private LocalDateTime regDate;
    private LocalDateTime modDate;
}
